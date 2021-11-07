package dao;

import entity.Bill;
import entity.Transaction;
import entity.TransactionCategory;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.sql.*;
import java.util.Properties;

public class BillDao {
    private final Logger log = LoggerFactory.getLogger(BillDao.class);

    public int getBillIdByUserName(String userName) {
        Configuration configuration = new Configuration().configure();
        int bill_id;
        EntityManager entityManager = null;
        try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
            entityManager = sessionFactory.createEntityManager();
            TypedQuery<Bill> query = entityManager.createQuery(
                    "SELECT b FROM Bill AS b WHERE b.owner.name =:n", Bill.class).setParameter("n", userName);
            log.info("\n selected bill from db where owner == name");

            bill_id = query.getSingleResult().getId();
            entityManager.close();
        } catch (ExceptionInInitializerError e) {

            if (entityManager.getTransaction() != null) entityManager.getTransaction().rollback();
            log.error("\n can`t connect to db" + e.getMessage());
            throw new RuntimeException(e);
        }
        return bill_id;
    }

    public void update(Transaction t, int id) {
        Configuration configuration = new Configuration().configure();
        EntityManager entityManager = null;
        try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
            entityManager = sessionFactory.createEntityManager();
            entityManager.getTransaction().begin();
            Bill b = entityManager.find(Bill.class, id);
            b.addTransaction(t);
            b.setAmountInCoins(b.getAmountInCoins() + t.getAmount());
            entityManager.persist(b);
            if (entityManager.getTransaction().isActive()) entityManager.getTransaction().commit();
            entityManager.close();
        } catch (ExceptionInInitializerError e) {
            if (entityManager.getTransaction() != null) entityManager.getTransaction().rollback();
            log.error("\n can`t connect to db" + e.getMessage());
            throw new RuntimeException(e);
        }
    }


    public Connection connectToDB() throws SQLException {
        Properties properties = new Properties();
        try (InputStream input = dao.BillDao.class.getResourceAsStream("/jdbc.properties")) {
            properties.load(input);
            return DriverManager.getConnection(properties.getProperty("url"));
        } catch (IOException e) {
            log.error("\n error occurred during process of extracting conection properties");
            throw new UncheckedIOException(e);

        }
    }

    public String getTransactionsByDate(int bill_id, String dateFrom, String dateTo) {
        Connection con = null;
        try {
            con = connectToDB();
            PreparedStatement pst = con.prepareStatement("SELECT *FROM transactions WHERE  bill_id =? AND transaction_time  BETWEEN ? AND ?");
            pst.setInt(1, bill_id);
            pst.setTimestamp(2, Timestamp.valueOf(dateFrom));
            pst.setTimestamp(3, Timestamp.valueOf(dateTo));

            ResultSet rs = pst.executeQuery();
            String res = "\n_______________________________ TRANSACTIONS INFO ___________________________________\n";
            String typeOfOperation;
            while (rs.next()) {
                if (rs.getInt(2) < 0) typeOfOperation = "expense";
                else typeOfOperation = "income";
                res = res + "\nid: " + rs.getString(1)
                        + ". amount: " + rs.getInt(2)
                        + ". operation-type: " + typeOfOperation
                        + ". transaction-category: " + TransactionCategory.toString(rs.getInt(3))
                        + ". transaction-time: " + rs.getString(4)
                        + ". bill_id: " + rs.getString(5)
                        + "\n\t\t________________________________________________________\n";
            }
            log.info("\n data was successfully obtained");
            return res;

        } catch (SQLException e) {

            log.error("\n can`t connect to db" + e.getMessage());
            e.printStackTrace();
            try {
                con.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
                log.error("\n error occurred: " + ex.getMessage());
            }
        }
        log.info("\n EMPTY RESULT got during find-by-date");
        return " EMPTY RESULT";
    }
}
