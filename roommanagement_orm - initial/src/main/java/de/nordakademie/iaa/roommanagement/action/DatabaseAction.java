package de.nordakademie.iaa.roommanagement.action;

import de.nordakademie.iaa.roommanagement.RoomManagement;
import de.nordakademie.iaa.roommanagement.dao.CourseDAO;
import de.nordakademie.iaa.roommanagement.dao.LectureDAO;
import de.nordakademie.iaa.roommanagement.dao.RoomDAO;
import de.nordakademie.iaa.roommanagement.model.Room;
import de.nordakademie.iaa.roommanagement.service.CourseService;
import de.nordakademie.iaa.roommanagement.service.LectureService;
import de.nordakademie.iaa.roommanagement.service.RoomService;

/**
 * Action that is provided with a transaction.
 */
public abstract class DatabaseAction extends Action {

    /**
     * Returns the {@link RoomDAO} instance.
     *
     * @return an instance of the service.
     */
    public RoomService getRoomService() {
        return RoomManagement.getApplicationContext().getBean(RoomService.class);
    }
    public CourseService getCourseService() {
        return RoomManagement.getApplicationContext().getBean(CourseService.class);
    }
    public LectureService getLectureService() {
        return RoomManagement.getApplicationContext().getBean(LectureService.class);
    }
}
