package persistance.dao;

import config.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import persistance.entity.Student;
import javax.persistence.Query;
import java.util.List;

@Repository
public class StudentDAO {




    public List<Student> findStudent() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query findStudentQuery = session.createNamedQuery("Find_Student");
        List<Student> studentList = findStudentQuery.getResultList();
        session.getTransaction().commit();
        session.close();
        return studentList;
    }

    public void insertStudent(Student student){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(student);
        session.getTransaction().commit();
        session.close();
    }

}
