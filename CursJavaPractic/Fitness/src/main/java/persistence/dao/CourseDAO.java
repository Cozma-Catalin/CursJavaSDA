package persistence.dao;

import org.hibernate.query.Query;
import persistence.hibernateConfig.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import persistence.entities.Course;

@Repository
public class CourseDAO {

    public void insertCourse(Course course){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(course);
        session.getTransaction().commit();
        session.close();
    }

    public long deleteCourse(String name){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query deleteCourseQuery = session.createNamedQuery("deleteCourse");
        deleteCourseQuery.setParameter("name",name);
        long result = (Long) deleteCourseQuery.getSingleResult();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    public long countCourse(String name){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query countCourseQuery = session.createNamedQuery("countCourse");
        countCourseQuery.setParameter("name",name);
        long result = (Long) countCourseQuery.getSingleResult();
        session.getTransaction().commit();
        session.close();
        return result;
    }
}
