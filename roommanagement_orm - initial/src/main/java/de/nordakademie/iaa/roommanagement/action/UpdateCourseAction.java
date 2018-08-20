package de.nordakademie.iaa.roommanagement.action;

import de.nordakademie.iaa.roommanagement.dao.CourseDAO;
import de.nordakademie.iaa.roommanagement.model.Course;
import de.nordakademie.iaa.roommanagement.util.ConsoleUtil;

public class UpdateCourseAction extends DatabaseAction {


    @Override
    public String getLabel() {
        return "Vorlesung updaten!";
    }

    @Override
    public void execute() throws Exception {
        System.out.println("Welchen Course möchtest du ändern? (ID eingeben)");
        long courseId = ConsoleUtil.readLong();

        Course course = CourseDAO.showCourse(courseId);

        System.out.println(String.format("Möchtest du den Dozenten '%s' ändern?", course.getLecturer()));
        if (ConsoleUtil.readBoolean()) {
            System.out.println("Wie soll der neue Dozent heißen?");
            course.setLecturer(ConsoleUtil.readString());
        }

        System.out.println(String.format("Möchtest du den Titel '%s' ändern?", course.getTitle()));
        if (ConsoleUtil.readBoolean()) {
            System.out.println("Wie soll der neue Titel heißen?");
            course.setTitle(ConsoleUtil.readString());
        }

        System.out.println("Die Vorlesung wurde upgedated!");
    }
}
