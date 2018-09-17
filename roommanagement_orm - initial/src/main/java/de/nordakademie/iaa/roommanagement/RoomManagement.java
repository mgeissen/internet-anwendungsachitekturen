package de.nordakademie.iaa.roommanagement;

import java.util.ArrayList;
import java.util.List;

import de.nordakademie.iaa.roommanagement.action.*;
import de.nordakademie.iaa.roommanagement.util.ApplicationController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Main class of the room management application.
 */
public class RoomManagement {

	private static ApplicationContext applicationContext;

	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	/**
	 * Runs the application.
	 * 
	 * @param args
	 *            Arguments (not supported).
	 */
	public static void main(String[] args) {
		// init spring
		applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");

		ApplicationController controller = new ApplicationController();
		// Create list of actions
		List<Action> actions = new ArrayList<>();
		actions.add(new ListRoomsAction());
		actions.add(new ShowRoomAction());
		actions.add(new CreateRoomAction());
		actions.add(new UpdateRoomAction());
		actions.add(new DeleteRoomAction());
		actions.add(new ListCoursesAction());
		actions.add(new ShowCourseAction());
		actions.add(new CreateCourseAction());
		actions.add(new UpdateCourseAction());
		actions.add(new DeleteCourseAction());
		actions.add(new ListLectureAction());
		actions.add(new ShowLectureAction());
		actions.add(new CreateLectureAction());
		actions.add(new DeleteLectureAction());
		actions.add(new ExitAction());

		// configure the controller
		controller.setActions(actions);
		// Show menu
		controller.showMenu();
	}
}
