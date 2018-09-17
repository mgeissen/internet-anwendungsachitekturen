package de.nordakademie.iaa.roommanagement.service;

import de.nordakademie.iaa.roommanagement.dao.CourseDAO;
import de.nordakademie.iaa.roommanagement.model.Course;

import javax.inject.Inject;
import java.util.List;

public class CourseService {

    private CourseDAO courseDAO;

    public Course createCourse(Course course) {
        return courseDAO.createCourse(course);
    }

    public List<Course> listCourse() {
        return courseDAO.listCourse();
    }

    public Course findByNaturalId(String fieldOfStudy, Integer roomNumber) {
        return courseDAO.findByNaturalId(fieldOfStudy, roomNumber);
    }

    public Course showCourse(long courseId) {
        return courseDAO.showCourse(courseId);
    }

    @Inject
    public void setCourseDAO(CourseDAO courseDAO) {
        this.courseDAO = courseDAO;
    }
}
