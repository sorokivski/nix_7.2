package entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", unique = true)
    private int id;

    @Column(name = "user_name", nullable = false)
    private String name;

    @Column(name = "user_phone_num")
    private String phoneNum;

    @Column(name = "user_email")
    private String email;

    @OneToMany(mappedBy = "owner", fetch = FetchType.LAZY)
    private List<Bill> userBills;


    public User() {
        this.userBills = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Bill> getUserBills() {
        return userBills;
    }

    public void setUserBills(List<Bill> userBills) {
        this.userBills = userBills;
    }

    public void addUserBill(Bill bill) {
        userBills.add(bill);
    }


}
