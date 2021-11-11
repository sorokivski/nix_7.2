package dao;

import entity.Course;
import entity.Lesson;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class LessonDao {

    public Lesson getNextLessonInCourse(EntityManager entityManager, Course course) {

        try {
            entityManager.getTransaction().begin();

            TypedQuery<Lesson> q = entityManager
                    .createQuery("Select ls FROM Lesson ls WHERE ls.course.id = :id AND ls.startTime > CURRENT_TIMESTAMP ORDER BY ls.startTime ASC", Lesson.class)
                    .setParameter("id", course.getId())
                    .setMaxResults(1);

            entityManager.getTransaction().commit();

            return q.getSingleResult();
        } catch (Exception e) {
            if (entityManager.getTransaction() != null) entityManager.getTransaction().rollback();
            System.out.println("Error: " + e.getMessage());

        }
        return null;
    }

}

