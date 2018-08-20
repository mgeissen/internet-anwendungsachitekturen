package de.nordakademie.iaa.roommanagement.dao;

public class CourseAlreadyExistException extends RuntimeException {

    public CourseAlreadyExistException() {
        super("Der Course existiert bereits!");
    }
}
