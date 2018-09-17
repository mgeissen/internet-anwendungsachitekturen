package de.nordakademie.iaa.roommanagement.action;

import de.nordakademie.iaa.roommanagement.model.Course;
import de.nordakademie.iaa.roommanagement.model.Lecture;
import de.nordakademie.iaa.roommanagement.model.Room;
import de.nordakademie.iaa.roommanagement.util.ConsoleUtil;

import java.util.Date;
import java.util.List;

public class CreateLectureAction extends DatabaseAction {


    @Override
    public String getLabel() {
        return "Erzeuge Veranstaltung";
    }

    @Override
    public void execute() throws Exception {
        System.out.println("Welche Raum?");
        List<Room> rooms = getRoomService().listRooms();
        for (int i = 0; i < rooms.size(); i++) {
            System.out.printf("(%d) %s%n", i, rooms.get(i).toString());
        }
        int roomIndex = ConsoleUtil.readInt();
        Room room = rooms.get(roomIndex);

        System.out.println("Welche Vorlesung?");
        List<Course> courses = getCourseService().listCourse();
        for (int i = 0; i < courses.size(); i++) {
            System.out.printf("(%d) %s%n", i, courses.get(i).toString());
        }
        int courseIndex = ConsoleUtil.readInt();
        Course course = courses.get(courseIndex);

        System.out.println("Wann startet die Veranstaltung?");
        Date startDate = ConsoleUtil.readDate();

        System.out.println("Wann endet die Veranstaltung?");
        Date endDate = ConsoleUtil.readDate();

        Lecture lecture = Lecture.builder()
                .withCourse(course)
                .withRoom(room)
                .withStartDate(startDate)
                .withEndDate(endDate)
                .build();

        lecture = getLectureService().createLecture(lecture);
        System.out.printf("Veranstaltung mit Id %d ist erfolgreich angelegt.%n", lecture.getId());
    }
}
