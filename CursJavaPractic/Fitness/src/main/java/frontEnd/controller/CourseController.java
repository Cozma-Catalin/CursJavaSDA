package frontEnd.controller;

import business.dto.CourseDTO;
import business.dto.GymDTO;
import business.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class CourseController {

    @Autowired
    CourseService courseService;

    @DeleteMapping(path = "/deleteCourse")
    public String deleteCourse(@RequestParam String name) {
        long result = courseService.deleteCourseDTO(name);
        if (result == 0) {
            return "No course found by this name.";
        }
        return "Course deleted.";
    }

    @PostMapping(path = "/insertCourse")
    public String insertCourse(@RequestBody @Valid CourseDTO courseDTO) {
        long result = courseService.countCourseDTO(courseDTO.getName());
            if (result != 0) {
                return "This course is already in the data base.";
            }
        courseService.insertCourseDTO(courseDTO);
        return courseDTO.getName() + " added.";
    }


}
