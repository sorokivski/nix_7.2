package entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "lessons", schema = "unit_13")
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private int id;

    @OneToMany(mappedBy = "lesson", fetch = FetchType.LAZY)
    private Set<Theme> themes;

    @Column(name = "start", nullable = false)
    private Timestamp startTime;

    @Column(name = "end", nullable = false)
    private Timestamp endTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "professor_id")
    private Professor professor;


    public Lesson() {
        this.themes = new HashSet<>();
    }

    public Set<Theme> getThemes() {
        return themes;
    }

    public void addTheme(Theme th) {
        themes.add(th);
        th.setLesson(this);
    }

    public void setThemes(Set<Theme> themes) {
        this.themes = themes;
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
