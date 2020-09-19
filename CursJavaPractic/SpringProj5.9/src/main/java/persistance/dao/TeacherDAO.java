package persistance.dao;

import config.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import persistance.entity.Teacher;

import javax.persistence.Query;
import java.util.List;

@Repository
public class TeacherDAO {
    public void insertTeacher(Teacher teacher){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(teacher);
        session.getTransaction().commit();
        session.close();
    }

    public List<Teacher> findTeacher(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query findTeacherQuery = session.createNamedQuery("Find_Teacher");
        List<Teacher> teacherList = findTeacherQuery.getResultList();
        session.getTransaction().commit();
        session.close();
        return teacherList;
    }
}
