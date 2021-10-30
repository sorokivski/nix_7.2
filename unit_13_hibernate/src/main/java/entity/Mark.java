package entity;

import javax.persistence.*;

@Entity
@Table(name = "marks", schema = "unit_13")
public class Mark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="mark", unique=true)
    private int mark;

    @ManyToOne
    @JoinColumn( name = "id")
    Student student;

    @ManyToOne
    @JoinColumn (name = "theme_id")
    Professor professor;

    @ManyToOne
    @JoinColumn (name = "theme_id")
    Theme theme;
    public Mark(){

    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Theme getTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }

}
