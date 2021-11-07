package dao;

import entity.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;

public class TransactionDao {

    private final Logger log = LoggerFactory.getLogger(TransactionDao.class);
    private BillDao bdao = new BillDao();

    public void newTransactionForUser(String clientName, Transaction t) {
        Configuration configuration = new Configuration().configure();
        EntityManager entityManager = null;
        try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
            entityManager = sessionFactory.createEntityManager();
            entityManager.getTransaction().begin();
            int bill_id = bdao.getBillIdByUserName(clientName);
            t.setBillId(bill_id);
            bdao.update(t, bill_id);
            entityManager.persist(t);

            log.info("\n updated table transactions");
            if (entityManager.getTransaction().isActive())
                entityManager.getTransaction().commit();
            entityManager.close();

            log.info("\n added transaction for bill by user name");

        } catch (ExceptionInInitializerError e) {
            if (entityManager != null && entityManager.getTransaction() != null)
                entityManager.getTransaction().rollback();
            log.error("\n can`t connect to db " + e.getMessage());

        }
    }

    public String getTransaction(Transaction t) {
        String result = " ";
        Configuration configuration = new Configuration().configure();

        EntityManager entityManager = null;
        try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
            entityManager = sessionFactory.createEntityManager();
            entityManager.getTransaction().begin();
            Transaction b = entityManager.getReference(Transaction.class, t.getId());
            result = b.toString();
            entityManager.close();
        } catch (ExceptionInInitializerError e) {
            if (entityManager.getTransaction() != null) entityManager.getTransaction().rollback();
            log.error("can`t connect to db" + e.getMessage());
            throw new RuntimeException(e);
        }
        log.info("\n transaction was added into table, all steps are done");
        return result;
    }

    public String getAllTransactionsByBillId(int billId, String dateFrom, String dateTo) {
        return bdao.getTransactionsByDate(billId, dateFrom, dateTo);
    }
}
