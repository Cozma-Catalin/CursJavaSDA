package frontEnd;

import business.StudentDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentsController {

    @GetMapping("/findStudents")
    public List<StudentDTO> findStudents(){
        List<StudentDTO> listaStudenti = new ArrayList<>();
        StudentDTO studentDTO = new StudentDTO("Catalin");
        listaStudenti.add(studentDTO);
        return listaStudenti;
    }

    @GetMapping("/findStudentByName")
    public StudentDTO findStudentByName(@RequestParam String name){
        StudentDTO studentDTO = new StudentDTO("Vasile");
        return studentDTO;
    }

}
