package entity;

import javax.persistence.*;

@Entity
@Table(name = "themes", schema = "unit_13")
public class Theme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="theme_id", unique=true)
    private int id;

    @Column(name ="theme_title", nullable = false)
    private String name;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;
    public Theme(){

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
