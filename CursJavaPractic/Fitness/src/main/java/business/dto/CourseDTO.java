package business.dto;

import java.util.Set;

public class CourseDTO {
    private String name;
    private String courseType;
    private String date;
    private String time;
    private int duration;
    private TrainerDTO trainerDTO;
    private Set<GymDTO> gymDTOSet;

    public CourseDTO(String name, String courseType, String date, String time, int duration, TrainerDTO trainerDTO, Set<GymDTO> gymDTOSet) {
        this.name = name;
        this.courseType = courseType;
        this.date = date;
        this.time = time;
        this.duration = duration;
        this.trainerDTO = trainerDTO;
        this.gymDTOSet = gymDTOSet;
    }

    public CourseDTO(String name, String courseType, String date, String time, int duration, TrainerDTO trainerDTO) {
        this.name = name;
        this.courseType = courseType;
        this.date = date;
        this.time = time;
        this.duration = duration;
        this.trainerDTO = trainerDTO;
    }

    public CourseDTO(String courseType, String date, String time, int duration) {
        this.courseType = courseType;
        this.date = date;
        this.time = time;
        this.duration = duration;
    }

    public CourseDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public TrainerDTO getTrainerDTO() {
        return trainerDTO;
    }

    public void setTrainerDTO(TrainerDTO trainerDTO) {
        this.trainerDTO = trainerDTO;
    }

    public Set<GymDTO> getGymDTOSet() {
        return gymDTOSet;
    }

    public void setGymDTOSet(Set<GymDTO> gymDTOSet) {
        this.gymDTOSet = gymDTOSet;
    }
}
