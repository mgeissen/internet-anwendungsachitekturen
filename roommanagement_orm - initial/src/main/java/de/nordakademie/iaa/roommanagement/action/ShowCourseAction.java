package de.nordakademie.iaa.roommanagement.action;

import de.nordakademie.iaa.roommanagement.dao.CourseDAO;
import de.nordakademie.iaa.roommanagement.model.Course;
import de.nordakademie.iaa.roommanagement.util.ConsoleUtil;
import javafx.scene.chart.PieChart;

public class ShowCourseAction extends DatabaseAction {
    @Override
    public String getLabel() {
        return "Zeige mir einen Kurs an!";
    }

    @Override
    public void execute() throws Exception {
        System.out.println("Welchen Kurs soll angezeigt werden?");
        long courseId = ConsoleUtil.readLong();

        Course course = CourseDAO.showCourse(courseId);
        System.out.println(course);
    }
}
