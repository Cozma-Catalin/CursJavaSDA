package persistance.dao;

import org.hibernate.Session;
import persistance.entities.Student;
import javax.persistence.Query;
import java.util.List;

public class StudentDAO {

    public void insert(Student student){
      Session session = HibernateUtil.getSessionFactory().openSession();
      session.beginTransaction();
      session.save(student);
      session.getTransaction().commit();
      session.close();

    }

    public List<Student> findStudentByName(String name){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query findStudentByNameQuery = session.createNamedQuery("Find_Student_By_Name");
        findStudentByNameQuery.setParameter("name",name);
        List<Student> studentList = findStudentByNameQuery.getResultList();
        session.getTransaction().commit();
        session.close();
        return studentList;
    }

    public List<Student> findStudentByYearOfBirth(int yearOfBirth){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query findStudentByYearOfBirthQuery = session.createNamedQuery("Find_Student_By_Year_Of_Birth");
        findStudentByYearOfBirthQuery.setParameter("yearOfBirth",yearOfBirth);
        List<Student> studentList = findStudentByYearOfBirthQuery.getResultList();
        session.getTransaction().commit();
        session.close();
        return studentList;
    }

    public int deleteStudenByName(String name){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query deleteStudentByNameQuery = session.createNamedQuery("Delete_Student_By_Name");
        deleteStudentByNameQuery.setParameter("name",name);
        int result = deleteStudentByNameQuery.executeUpdate();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    public int deleteStudentByYearOfBirth(int yearOfBirth){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query deleteStudentByYearOfBirthQuery = session.createNamedQuery("Delete_Student_By_Year_Of_Birth");
        deleteStudentByYearOfBirthQuery.setParameter("yearOfBirth",yearOfBirth);
        int result = deleteStudentByYearOfBirthQuery.executeUpdate();
        session.getTransaction().commit();
        session.close();
        return result;
    }

}
