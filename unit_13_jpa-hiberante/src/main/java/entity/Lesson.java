package entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "lessons")
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true)
    protected int id;

    @OneToMany(mappedBy = "lesson", fetch = FetchType.LAZY)
    protected Set<Theme> themes;

    @Column(name = "start_time", nullable = false)
    protected Timestamp startTime;

    @Column(name = "end_time", nullable = false)
    protected Timestamp endTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    protected Course course;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "professor_id")
    protected Professor professor;


    public Lesson() {
        this.themes = new HashSet<>();
    }

    public Set<Theme> getThemes() {
        return themes;
    }

    public void setThemes(Set<Theme> themes) {
        this.themes = themes;
    }

    public void addTheme(Theme th) {
        themes.add(th);
        th.setLesson(this);
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public String toString() {
        return "Next lesson time:" + this.startTime +
                " - " + this.endTime + "\n";
    }
}
