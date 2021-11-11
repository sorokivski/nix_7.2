package entity;


import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.Set;
import java.util.TreeSet;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id", unique = true)
    private int id;

    @Column(name = "student_name", nullable = false)
    private String name;

    @Column(name = "student_phone")
    private String phoneNum;

    @NaturalId
    @Column(name = "student_email", nullable = false)
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    @Access(AccessType.PROPERTY)
    private Group group;

    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
    private Set<Mark> marks;

    public Student() {
        this.marks = new TreeSet();
    }

    public void addMark(Mark m) {
        marks.add(m);
        m.student = this;
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

    public void setName(String n) {
        name = n;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String ph) {
        this.phoneNum = ph;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String e) {
        this.email = e;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group a) {
        this.group = a;
    }

    public Set<Mark> getMarks() {
        return marks;
    }

    public void setMarks(Set<Mark> m) {
        marks = m;
    }
}
