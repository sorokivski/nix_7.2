package service;

import dao.LessonDao;
import dao.StudentDao;
import entity.Course;
import entity.Lesson;
import entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;

public class Unit13Service {
    public String findNextLessonForStudent(String studentName){
    String lesson = " ";
        Configuration configuration = new Configuration().configure();
      //  configuration.configure("hibernate.cfg.xml");
   //     StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
//        sessionFactory = configuration.buildSessionFactory(ssrb.build());
        try(SessionFactory sessionFactory = configuration.buildSessionFactory()) {
            EntityManager entityManager = sessionFactory.createEntityManager();
            Student student = new StudentDao().getStudentByName(entityManager, studentName);
            if(student!=null){

                Course course = student.getGroup().getCourse();
               Lesson next = new LessonDao().getNextLessonInCourse(entityManager,course);
               if(next!=null)lesson = next.toString();
            }

        }catch( ExceptionInInitializerError e){
           lesson = "can`t connect to db";
        }
        return lesson;
    }
}
