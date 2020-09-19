import entities.Student;
import entities.Teacher;
import org.hibernate.Session;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();
        Session session = metadata.getSessionFactoryBuilder().build().openSession();
        session.beginTransaction();
        Teacher teacher = new Teacher();
        teacher.setName("Cristina");
        teacher.setSurname("Robu");
        teacher.setAge(45);
        teacher.setExpertise("Matematica");
        teacher.setTenure(1);
        session.save(teacher);
        session.getTransaction().commit();

        session.beginTransaction();
        Student student = new Student();
        student.setName("Marius");
        student.setSurname("Lacatus");
        student.setBirthYear(1977);
        student.setMajor("Fotbal");
        session.save(student);
        session.getTransaction().commit();

        session.beginTransaction();
        Query deleteStudentsByYear = session.createNamedQuery("Delete_Student_By_Year");
        deleteStudentsByYear.setParameter("birthYear", 1987);
        int result = deleteStudentsByYear.executeUpdate();
        session.getTransaction().commit();
        System.out.println(result);


        session.beginTransaction();
        Query deleteStudentsByMajor = session.createNamedQuery("Delete_Student_By_Major");
        deleteStudentsByMajor.setParameter("major", "fotbal");
        result = deleteStudentsByMajor.executeUpdate();
        session.getTransaction().commit();
        System.out.println(result);


        session.beginTransaction();
        Query deleteTeacherByTenure = session.createNamedQuery("Delete_Teacher_By_Tenure");
        deleteTeacherByTenure.setParameter("tenure", 1);
        result = deleteTeacherByTenure.executeUpdate();
        session.getTransaction().commit();
        System.out.println(result);

        session.beginTransaction();
        Student student2 = new Student();
        student2.setName("Marius");
        student2.setSurname("Lacatus");
        student2.setBirthYear(1977);
        student2.setMajor("Fotbal");
        session.save(student2);
        session.getTransaction().commit();



        session.beginTransaction();
        Query updateStudentsMajor = session.createNamedQuery("Update_Students_Major_Before_Year");
        updateStudentsMajor.setParameter("major","matematica");
        updateStudentsMajor.setParameter("birthYear",1992);
        result = updateStudentsMajor.executeUpdate();
        session.getTransaction().commit();
        System.out.println(result);

        session.beginTransaction();
        Teacher teacher2 = new Teacher();
        teacher2.setName("Cristina");
        teacher2.setSurname("Robu");
        teacher2.setAge(45);
        teacher2.setExpertise("Matematica");
        teacher2.setTenure(0);
        session.save(teacher2);
        session.getTransaction().commit();



        session.beginTransaction();
        Query updateTeachersExpertise = session.createNamedQuery("Update_Teacher_Expertise");
        updateTeachersExpertise.setParameter("expertise","fotbal");
        updateTeachersExpertise.setParameter("tenure", 0);
        result = updateTeachersExpertise.executeUpdate();
        System.out.println(result);
        session.getTransaction().commit();


        session.beginTransaction();
        Query selectStudentsByBirthYear = session.createNamedQuery("Select_Students_By_BirthYear");
        selectStudentsByBirthYear.setParameter("birthYear",1977);
        List<Student> studentList = selectStudentsByBirthYear.getResultList();
        for(Student student3 : studentList){
            System.out.println(student3);
        }
        session.getTransaction().commit();



        session.beginTransaction();
        Query selectTeachers = session.createNamedQuery("Select_Teachers_By_Age");
        selectTeachers.setParameter("age",40);
        List<Teacher> teacherList = selectTeachers.getResultList();
        for(Teacher teacher3 : teacherList){
            System.out.println(teacher3);
        }
        session.getTransaction().commit();





        session.close();

    }
}
