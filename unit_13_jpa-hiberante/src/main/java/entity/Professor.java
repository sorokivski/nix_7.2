package entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "professors")
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "professor_id", unique = true)
    private int id;

    @Column(name = "professor_name", nullable = false)
    private String name;

    @Column(name = "professor_phone")
    private String phoneNum;

    @Column(name = "professor_email", nullable = false)
    private String email;

    @OneToMany(mappedBy = "professor", fetch = FetchType.LAZY)
    private Set<Lesson> lessons;

    public Professor() {
        this.lessons = new HashSet<>();
    }

    public void addLesson(Lesson l) {
        lessons.add(l);
        l.setProfessor(this);
    }

    public void removeLesson(Lesson lesson) {
        if (lessons.contains(lesson)) {
            lessons.remove(lesson);
        }
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

    public void setPhoneNum(String phone) {
        this.phoneNum = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String e) {
        this.email = e;
    }

    public Set<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(Set<Lesson> l) {
        this.lessons = l;
    }


}
