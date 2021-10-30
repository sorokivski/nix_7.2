package entity;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.Set;
import java.util.TreeSet;

@Entity
@Table(name = "students", schema = "unit_13")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="student_id", unique=true)
    private Long id;

    @Column(name = "student_name", nullable = false)
    private String name;

    @Column(name = "student_phone")
    private String phoneNum;

    @NaturalId
    @Column(name = "student_email", nullable = false)
    private String email;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    @Access(AccessType.PROPERTY)
    private Group group;

    @OneToMany(mappedBy="student", fetch=FetchType.LAZY)
    private Set<Mark> marks;

    public Student() {
        this.marks = new TreeSet();
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String n) {
        name = n;
    }
    public void setPhoneNum(String ph){
        this.phoneNum = ph;
    }
    public void setEmail(String e) {
        this.email = e;
    }
    public void setGroup(Group a) {
        this.group = a;
    }
    public void setMarks(Set<Mark> m){
        marks = m;
    }
    public void addMark(Mark m){
        marks.add(m);
        m.student = this;
    }
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getPhoneNum(){
        return phoneNum;
    }
    public String getEmail() {
        return email;
    }
    public Group getGroup() {
        return group;
    }
    public Set<Mark> getMarks(){
        return marks;
    }
}
