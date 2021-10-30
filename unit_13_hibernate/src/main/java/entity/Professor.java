package entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "professors", schema = "unit_13")
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="professor_id", unique=true)
    private Long id;

    @Column(name = "professor_name", nullable = false)
    private String name;

    @Column(name = "professor_phone")
    private String phoneNum;

    @Column(name = "professor_email", nullable = false)
    private String email;

    @OneToMany(mappedBy="professor", fetch=FetchType.LAZY)
    private Set<Lesson> lessons;

    public Professor() {
        this.lessons = new HashSet<>();
    }
    public void setId(Long id){
        this.id= id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setPhoneNum(String phone){
        this.phoneNum = phone;
    }
    public void setEmail(String e){
        this.email= e;
    }
    public void setLessons(Set<Lesson>l){
        this.lessons=l;
    }
    public void addLesson(Lesson l){
       lessons.add(l);
       l.setProfessor(this);
    }
    public void removeLesson(Lesson lesson){
        if(lessons.contains(lesson)){
            lessons.remove(lesson);
        }
    }

    public Long getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getPhoneNum(){
        return phoneNum;
    }
    public String getEmail(){
        return email;
    }
    public Set<Lesson> getLessons(){
        return lessons;
    }


}
