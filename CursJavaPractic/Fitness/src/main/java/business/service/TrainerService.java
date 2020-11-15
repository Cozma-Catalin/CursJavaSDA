package business.service;

import business.dto.CourseDTO;
import business.dto.GymDTO;
import business.dto.TrainerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistence.dao.TrainerDAO;
import persistence.entities.Course;
import persistence.entities.Gym;
import persistence.entities.Trainer;

import java.util.HashSet;
import java.util.Set;

@Service
public class TrainerService {

    @Autowired
    TrainerDAO trainerDAO;

    public void addTrainerDTO(TrainerDTO trainerDTO){
        Trainer trainer = new Trainer();
        trainer.setName(trainerDTO.getName());
        trainer.setSurname(trainerDTO.getSurname());
        trainer.setBirthDate(trainerDTO.getBirthDate());
        trainer.setSalary(trainerDTO.getSalary());

        setCourses(trainerDTO, trainer);
        setGyms(trainerDTO, trainer);

        trainerDAO.addTrainer(trainer);
    }

    private void setGyms(TrainerDTO trainerDTO, Trainer trainer) {
        Set<Gym> gymSet = new HashSet<>();
        Gym gym = new Gym();
        for(GymDTO g:trainerDTO.getGymDTOSet()){
            gym.setName(g.getName());
            gym.setAddress(g.getAddress());
            gym.setCity(g.getCity());
            gymSet.add(gym);
        }
        trainer.setGymSet(gymSet);
    }

    private void setCourses(TrainerDTO trainerDTO, Trainer trainer) {
        Set<Course> courseSet = new HashSet<>();
        Course course = new Course();
        for(CourseDTO c: trainerDTO.getCourseDTOSet()){
            course.setCourseType(c.getCourseType());
            course.setDate(c.getDate());
            course.setTime(c.getTime());
            course.setDuration(c.getDuration());
            courseSet.add(course);
        }
        trainer.setCourseSet(courseSet);
    }

    public long countTrainerDTO(String name,String surname){
        long result = trainerDAO.countTrainer(name,surname);
        return result;
    }

    public int deleteTrainerDTO(String name,String surname){
        int result = trainerDAO.deleteTrainerByNameAndSurname(name,surname);
        return result;
    }
}
