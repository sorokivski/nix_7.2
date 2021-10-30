package dao;

import entity.Course;
import entity.Lesson;
import entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class LessonDao {

public  Lesson getNextLessonInCourse(EntityManager entityManager, Course course){

    try{
       entityManager.getTransaction().begin();

        TypedQuery<Lesson> q=entityManager
                .createQuery("FROM Lesson ls WHERE course = :id AND ls.startTime > CURRENT_TIMESTAMP ORDER BY ls.startTime ASC", Lesson.class)
                .setParameter( "id", course.getId())
                .setMaxResults(1);

        return q.getSingleResult();
    }catch (Exception e){
       // if(tx!=null) tx.rollback();
        System.out.println("Error: "+e.getMessage());

    }
    return null;
}

}

