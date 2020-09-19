package business.service;

import business.dto.TeacherDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistance.dao.TeacherDAO;
import persistance.entity.Teacher;

import java.util.ArrayList;
import java.util.List;
@Service
public class TeacherService {

   @Autowired
   TeacherDAO teacherDAO ;

    public void insertTeacherDTO(TeacherDTO teacherDTO){
        Teacher teacher = new Teacher();
        teacher.setName(teacherDTO.getName());
        teacher.setSurname(teacherDTO.getSurname());
        teacher.setMajor(teacherDTO.getMajor());
        teacherDAO.insertTeacher(teacher);
    }

    public List<TeacherDTO> findTeacher(){
        List<Teacher> teacherList = teacherDAO.findTeacher();
        List<TeacherDTO> teacherDTOList = new ArrayList<>();
        for(Teacher teacher : teacherList){
            TeacherDTO teacherDTO = new TeacherDTO();
            teacherDTO.setName(teacher.getName());
            teacherDTO.setSurname(teacher.getSurname());
            teacherDTO.setMajor(teacher.getMajor());
            teacherDTOList.add(teacherDTO);
        }
        return teacherDTOList;
    }
}
