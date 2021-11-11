package entity;

import javax.persistence.*;

@Entity
@Table(name = "marks")
public class Mark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    public int id;

    @Column(name = "mark")
    protected int mark;

    @ManyToOne
    @JoinColumn(name = "student_id")
    protected Student student;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    protected Professor professor;


    @ManyToOne
    @JoinColumn(name = "theme_id")
    protected Theme theme;

    public Mark() {

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
