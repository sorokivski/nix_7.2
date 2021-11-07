package entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "transaction_id", unique = true)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "bill_id")
    private Bill bill;

    @Column(name = "transaction_category", nullable = false)
    private TransactionCategory category;

    @Column(name = "transaction_time", nullable = false)
    private Timestamp transactionTime;

    @Column(name = "transaction_amount", nullable = false)
    private long amount;

    public Transaction() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public void setBillId(int id) {
        if (bill == null) bill = new Bill();
        bill.setId(id);
    }

    public TransactionCategory getCategory() {
        return category;
    }

    public void setCategory(TransactionCategory category) {
        this.category = category;
    }

    public Timestamp getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(Timestamp operationTime) {
        transactionTime = operationTime;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "\n___________________________________________________ \nTransaction: " +
                "\nid = " + id +
                ",\nbill = " + bill +
                ", \ncategory = " + category +
                ", \ntransactionTime = " + transactionTime +
                ", \namount = " + amount +
                "\n___________________________________________________________\n";
    }
}
