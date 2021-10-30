package entity;

import javax.persistence.*;
import java.util.Set;
import java.util.TreeSet;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id", unique=true)
    private Long id;

    @Column(name ="name")
    private String name;

    @OneToMany(mappedBy="course", fetch=FetchType.LAZY)
    @OrderBy()
    private Set<Lesson> lessons;

    @OneToMany(cascade = CascadeType.REMOVE,mappedBy = "course", fetch = FetchType.LAZY)
    private Set<Group> groups;

    public Course(){
        this.lessons = new TreeSet<>();
    }
    public void setId(Long id){
        this.id = id;
    }
    public void setLessons(Set<Lesson> l){
        this.lessons = l;
    }
    public void addLesson(Lesson l){
        lessons.add(l);
    }

    public void addGroup(Group group) {
    groups.add(group);
    }
    public Set<Group> getGroups() {
        return groups;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Long getId() {
        return id;
    }

    public Set<Lesson> getLessons() {
        return lessons;
    }

}
