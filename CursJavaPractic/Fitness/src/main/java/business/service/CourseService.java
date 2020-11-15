package business.service;

import business.dto.CourseDTO;
import business.dto.GymDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistence.dao.CourseDAO;
import persistence.entities.Course;
import persistence.entities.Gym;
import persistence.entities.Trainer;

import java.util.HashSet;
import java.util.Set;


@Service
public class CourseService {

    @Autowired
    CourseDAO courseDAO;

    public long deleteCourseDTO(String name){
        long result = courseDAO.deleteCourse(name);
        return result;
    }

    public void insertCourseDTO(CourseDTO courseDTO){
        Course course = getCourse(courseDTO);
        setGyms(courseDTO, course);
        setTrainer(courseDTO, course);

        courseDAO.insertCourse(course);
    }

    private Course getCourse(CourseDTO courseDTO) {
        Course course = new Course();
        course.setName(courseDTO.getName());
        course.setCourseType(courseDTO.getCourseType());
        course.setDate(courseDTO.getDate());
        course.setTime(courseDTO.getTime());
        course.setDuration(courseDTO.getDuration());
        return course;
    }

    private void setGyms(CourseDTO courseDTO, Course course) {
        Set<Gym> gymSet = new HashSet<>();
        Gym gym = new Gym();
        for(GymDTO g: courseDTO.getGymDTOSet()){
            gym.setName(g.getName());
            gym.setAddress(g.getAddress());
            gym.setCity(g.getCity());
            gymSet.add(gym);
        }
        course.setGymSet(gymSet);
    }

    private void setTrainer(CourseDTO courseDTO, Course course) {
        Trainer trainer = new Trainer();
        trainer.setName(courseDTO.getTrainerDTO().getName());
        trainer.setSurname(courseDTO.getTrainerDTO().getSurname());
        trainer.setBirthDate(courseDTO.getTrainerDTO().getBirthDate());
        trainer.setSalary(courseDTO.getTrainerDTO().getSalary());

        course.setTrainer(trainer);
    }

    public long countCourseDTO(String name){
        long result = courseDAO.countCourse(name);
        return result;
    }
}
