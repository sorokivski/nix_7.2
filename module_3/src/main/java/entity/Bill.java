package entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "bills")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bill_id", unique = true)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id")
    private User owner;

    @OneToMany(mappedBy = "bill"
            , fetch = FetchType.LAZY)

    private List<Transaction> transactions;

    @Column(name = "amount")
    private long amountInCoins;

    public Bill() {
        transactions = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public long getAmountInCoins() {
        return amountInCoins;
    }

    public void setAmountInCoins(long amountInCoins) {
        this.amountInCoins = amountInCoins;
    }

    public void addTransaction(Transaction t) {
        transactions.add(t);
        t.setBill(this);
    }

    public String toString() {
        return "bill: " + id + " amount: " + (double) getAmountInCoins() / 100;
    }

}
