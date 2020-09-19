package business.service;

import business.dto.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistance.dao.StudentDAO;
import persistance.entity.Student;
import java.util.ArrayList;
import java.util.List;
@Service
public class StudentService {

@Autowired
StudentDAO studentDAO ;

    public List<StudentDTO> findStudentDTO(){
        List<Student> studentList = studentDAO.findStudent();
        List<StudentDTO> studentDTOList = new ArrayList<>();
        for(Student student:studentList){
            StudentDTO studentDTO = new StudentDTO();
            studentDTO.setName(student.getName());
            studentDTO.setSurname(student.getSurname());
            studentDTOList.add(studentDTO);
        }
        return studentDTOList;
    }

    public void insertStudentDTO(StudentDTO studentDTO){
        Student student = new Student();
        student.setName(studentDTO.getName());
        student.setSurname(studentDTO.getSurname());
        student.setAge(studentDTO.getAge());
        studentDAO.insertStudent(student);
    }



}
