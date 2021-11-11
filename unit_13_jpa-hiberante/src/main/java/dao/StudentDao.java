package dao;


import entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class StudentDao {
    public Student getStudentByName(EntityManager entityManager, String n) {

        TypedQuery<Student> q = entityManager
                .createQuery("Select s FROM Student s where s.name =:n", Student.class)
                .setParameter("n", n).setMaxResults(1);

        return q.getSingleResult();

    }

}
