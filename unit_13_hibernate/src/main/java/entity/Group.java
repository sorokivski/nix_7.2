package entity;

import javax.persistence.*;
import java.util.Set;
import java.util.TreeSet;

@Entity
@Table(name = "groups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id", unique=true)
    private Long id;

    @Column(name ="name", unique=true)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "course_id")
    @Access(AccessType.PROPERTY)
    private Course course;

    @OneToMany(mappedBy="group", fetch=FetchType.LAZY)
    private Set<Student> students;

    public Group(){
        this.students = new TreeSet<>();
    }
public Group(Long id){
        this.id = id;
}
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
    public void addStudent(Student student) {
        students.add(student);
        student.setGroup(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
