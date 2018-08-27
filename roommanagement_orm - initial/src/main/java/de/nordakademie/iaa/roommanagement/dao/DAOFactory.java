package de.nordakademie.iaa.roommanagement.dao;

import de.nordakademie.iaa.roommanagement.model.Course;

/**
 * The dao factory. This class cannot be instantiated but provides static
 * methods to create (singleton) instances of the daos.
 * 
 * @author Stefan Reichert
 */
public final class DAOFactory {

	/**
	 * Hidden default constructor.
	 */
	private DAOFactory() {
		// Do nothing
	}

	/**
	 * Returns the {@link RoomDAO} instance.
	 * 
	 * @return an instance of the DAO.
	 */
	public static RoomDAO createRoomDAO() {
		return new RoomDAO();
	}
	public static CourseDAO createCourseDAO() {
		return new CourseDAO();
	}
	public static LectureDAO createLectureDAO() {
		return new LectureDAO();
	}
}
