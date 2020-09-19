package persistance.dao;

import org.hibernate.Session;
import persistance.entities.Teacher;

import javax.persistence.Query;
import java.util.List;

public class TeacherDAO {

        public void insertTeacher(Teacher teacherToInsert){
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(teacherToInsert);
            session.getTransaction().commit();
            session.close();
        }


    public int deleteTeacherByTenure(int tenure){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query deleteTeacherByTenureQuery = session.createNamedQuery("Delete_Teacher_By_Tenure");
        deleteTeacherByTenureQuery.setParameter("tenure",tenure);
        int result = deleteTeacherByTenureQuery.executeUpdate();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    public int updateTeacherExpertiseByTenure(String expertise,int tenure){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query updateTeacherExpertiseByTenureQuery = session.createNamedQuery("Update_Teacher_Expertise");
        updateTeacherExpertiseByTenureQuery.setParameter("expertise",expertise);
        updateTeacherExpertiseByTenureQuery.setParameter("tenure",tenure);
        int result = updateTeacherExpertiseByTenureQuery.executeUpdate();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    public List<Teacher> selectTeacherByAge(int age){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query selectTeacherByAgeQuery = session.createNamedQuery("Select_Teachers_By_Age");
        selectTeacherByAgeQuery.setParameter("age",age);
        List<Teacher> teacherList = selectTeacherByAgeQuery.getResultList();
        session.getTransaction().commit();
        session.close();
        return teacherList;
    }


}
