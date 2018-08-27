package de.nordakademie.iaa.roommanagement.action;

import de.nordakademie.iaa.roommanagement.dao.CourseDAO;
import de.nordakademie.iaa.roommanagement.dao.DAOFactory;
import de.nordakademie.iaa.roommanagement.model.Course;
import de.nordakademie.iaa.roommanagement.util.ConsoleUtil;
import sun.print.CUPSPrinter;

public class CreateCourseAction extends DatabaseAction {

    @Override
    public String getLabel() {
        return "Vorlesung anlegen!";
    }

    @Override
    public void execute() throws Exception {
        System.out.println("Geben den Studiengang ein:");
        String fieldOfStudy = ConsoleUtil.readString();

        System.out.println("Geben Sie die Vorlesungsnummer ein:");
        int number = ConsoleUtil.readInt();

        System.out.println("Bitte gebe den Dozenten ein:");
        String lecturer = ConsoleUtil.readString();

        System.out.println("Bitte gebe den Vorlesungsnamen ein:");
        String title = ConsoleUtil.readString();

        Course course = Course.builder()
                .withFieldOfStudy(fieldOfStudy)
                .withNumber(number)
                .withLecturer(lecturer)
                .withTitle(title)
                .build();

        course = DAOFactory.createCourseDAO().createCourse(course);

        System.out.printf("Der Course mit der ID %d wurde angelegt.%n", course.getId());
    }
}
