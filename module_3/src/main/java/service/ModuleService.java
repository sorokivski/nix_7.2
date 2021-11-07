package service;

import dao.TransactionDao;
import entity.Transaction;

public class ModuleService {

    TransactionDao tdao = new TransactionDao();

    public String addTransactionForExistingUser(String clientName, Transaction t) {
        tdao.newTransactionForUser(clientName, t);
        return tdao.getTransaction(t);
    }


    public String getBillTransactionsByBillId(int billId, String dateFrom, String dateTo) {
        return tdao.getAllTransactionsByBillId(billId, dateFrom, dateTo);
    }
}
