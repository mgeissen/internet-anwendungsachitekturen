package de.nordakademie.iaa.roommanagement.action;

import de.nordakademie.iaa.roommanagement.dao.CourseDAO;
import de.nordakademie.iaa.roommanagement.model.Course;

import java.util.List;

public class ListCoursesAction extends DatabaseAction {
    @Override
    public String getLabel() {
        return "Zeige alle Kurse an!";
    }

    @Override
    public void execute() throws Exception {
        List<Course> courses = CourseDAO.listCourse();
        courses.forEach(System.out::println);
    }
}
