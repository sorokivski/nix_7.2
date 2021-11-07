package controller;

import entity.Transaction;
import entity.TransactionCategory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.ModuleService;

import java.sql.Timestamp;
import java.util.Locale;
import java.util.Scanner;


public class ModuleController {
    private final Logger log = LoggerFactory.getLogger(ModuleController.class);
    ModuleService service = new ModuleService();
    private Scanner IN = new Scanner(System.in);

    public void run() {
        run1();
        run2();
    }

    public void run1() {
        System.out.println("Adding new transaction for user_name using JPA/Hibernate:" +
                "\n _________ Entering data about transaction ___________  \n Enter amount: ");
        Transaction t = new Transaction();
        String result1 = " ";
        try {

            t.setAmount(Integer.parseInt(IN.nextLine()));
            System.out.println("Enter category of operation: ");
            t.setCategory(TransactionCategory.valueOf(IN.nextLine().toUpperCase(Locale.ROOT)));
            System.out.println("Enter time of transaction in timestamp format: ");
            t.setTransactionTime(Timestamp.valueOf(IN.nextLine()));
            System.out.println("Enter name of client to add transaction: ");

            System.out.println(service.addTransactionForExistingUser(IN.nextLine(), t));

        } catch (IllegalArgumentException e) {
            log.error("\nBAD USER INPUT " + e);
        }
        System.out.println(result1);
    }


    public void run2() {
        System.out.println("_____________________ Selecting transactions using JDBC _______________________\n" +
                "Enter bill_id and the dates from-to in timestamp format to get list of operations: ");
        try {
            System.out.println(service
                    .getBillTransactionsByBillId(Integer.parseInt(IN.nextLine()), IN.nextLine(), IN.nextLine()));
        } catch (IllegalArgumentException e) {
            log.error("\nBAD USER INPUT " + e);
        }
    }
}
