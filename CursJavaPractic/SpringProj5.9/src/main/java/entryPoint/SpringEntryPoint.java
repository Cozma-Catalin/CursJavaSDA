package entryPoint;

import business.dto.StudentDTO;
import business.dto.TeacherDTO;
import business.service.StudentService;
import business.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class SpringEntryPoint {
   @Autowired
   StudentService studentService ;
   @Autowired
   TeacherService teacherService ;


    public void run(){


        List<StudentDTO> studentDTOList = studentService.findStudentDTO();
        for(StudentDTO student:studentDTOList){
            System.out.println(student);
        }

        StudentDTO studentDTO = new StudentDTO("Gica","Hagi",52);
        studentService.insertStudentDTO(studentDTO);


        TeacherDTO teacherDTO = new TeacherDTO("Mihaila","Daniela","Mate");
        teacherService.insertTeacherDTO(teacherDTO);
        List<TeacherDTO> teacherDTOList = teacherService.findTeacher();
        for(TeacherDTO teacher:teacherDTOList){
            System.out.println(teacher);
        }


    }
}
