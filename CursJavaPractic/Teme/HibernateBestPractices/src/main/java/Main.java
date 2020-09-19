import persistance.dao.StudentDAO;
import persistance.dao.TeacherDAO;
import persistance.entities.Address;
import persistance.entities.Student;
import persistance.entities.Teacher;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAO();
        TeacherDAO teacherDAO = new TeacherDAO();

//        Address address2 = new Address("Galati","Calugareni");
        /*//inseram un student
        Student studentToInsert = new Student("Cozma", "Catalin", 1989, "Info",address2);

        studentDAO.insert(studentToInsert);

        //cautam un student dupa nume

        List<Student> studentList = studentDAO.findStudentByName("Cozma");
        System.out.println("Afisam studentii in functie de nume.");
        for (Student student : studentList) {
            System.out.println(student);
        }

        //cautam un student dupa anul nasterii
        int yearOfBirth = 1989;
        List<Student> studentListByYear = studentDAO.findStudentByYearOfBirth(yearOfBirth);
        System.out.println("Afisam studentii in functie de anul de nastere.");
        for (Student student : studentListByYear) {
            System.out.println(student);
        }

        // stergem un student in functie de nume
        String name = "Cozma";
        int result = studentDAO.deleteStudenByName(name);
        System.out.println(result);

        Address address = new Address("Galati","Domneasca");
        Student student1 = new Student("Cristian", "Ilie", 1988, "Info",address);
        studentDAO.insert(student1);

        //stergem un student in functie de anul nasterii
        yearOfBirth = 1988;
        result = studentDAO.deleteStudentByYearOfBirth(yearOfBirth);
        System.out.println(result);

        Address address1 = new Address("Galati","Cosbuc");
        Student student3 = new Student("Cozma","Catalin",1989,"Info",address1);
        studentDAO.insert(student3);

        //inseram un teacher
        Teacher teacherToInsert = new Teacher("Cristina", "Robu", 35, "Matematica", "Engleza", 1);
        teacherDAO.insertTeacher(teacherToInsert);

        // stergem un teacher by tenure

        int tenure = 1;
        result = teacherDAO.deleteTeacherByTenure(tenure);
        System.out.println(result);

        Teacher teacher1 = new Teacher("Cristina", "Robu", 35, "Matematica", "Engleza", 1);
        teacherDAO.insertTeacher(teacher1);

        //update teachers expertise by tenure
        String expertise = "Director";
        result = teacherDAO.updateTeacherExpertiseByTenure(expertise,tenure);
        System.out.println(result);

        //selectam teacheru dupa age
        int age = 35;
        List<Teacher> teacherListByAge = teacherDAO.selectTeacherByAge(age);
        System.out.println("Afisam teacherii in fct de age.");
        for(Teacher teacher : teacherListByAge){
            System.out.println(teacher);
        }
*/
        //inseram studentul ...alex matei nascut in 1988 info nicolae grigorescu iasi
      /*  Address address3 = new Address("Nicolae Grigorescu","Iasi");
        Student studentAlex = new Student("Alex","Matei",1988,"Info",address3);
        studentDAO.insert(studentAlex);


        List<Student> studentList = studentDAO.findStudentByName("Alex");
        System.out.println("Afisam studentii in functie de nume.");
        for (Student student : studentList) {
            System.out.println(student);
        }

        Teacher teacher = new Teacher("Vasile","Cretu",45,"Matematica","Info",1,address3);
        teacherDAO.insertTeacher(teacher);
        List<Teacher> teacherList = teacherDAO.selectTeacherByAge(45);
        for(Teacher teacher1 : teacherList){
            System.out.println(teacher1);
        }
*/



    }
}
