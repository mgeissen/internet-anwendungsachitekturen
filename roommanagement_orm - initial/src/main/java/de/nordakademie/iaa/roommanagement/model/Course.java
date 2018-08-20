package de.nordakademie.iaa.roommanagement.model;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

@Entity
public class Course {

    private Long id;
    private String fieldOfStudy;
    private Integer number;
    private String lecturer;
    private String title;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NaturalId
    @Column(nullable = false, name = "field_of_study", length = 50)
    public String getFieldOfStudy() {
        return fieldOfStudy;
    }

    public void setFieldOfStudy(String fieldOfStudy) {
        this.fieldOfStudy = fieldOfStudy;
    }

    @NaturalId
    @Column(nullable = false, name = "number")
    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Basic
    @Column(nullable = false, name = "lecturer", length = 50)
    public String getLecturer() {
        return lecturer;
    }

    public void setLecturer(String lecturer) {
        this.lecturer = lecturer;
    }

    @Basic
    @Column(nullable = false, name = "title", length = 100)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public static CourseBuilder builder() {
        return new CourseBuilder();
    }

    public static final class CourseBuilder {
        private Long id;
        private String fieldOfStudy;
        private Integer number;
        private String lecturer;
        private String title;

        private CourseBuilder() {
        }

        public CourseBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public CourseBuilder withFieldOfStudy(String fieldOfStudy) {
            this.fieldOfStudy = fieldOfStudy;
            return this;
        }

        public CourseBuilder withNumber(Integer number) {
            this.number = number;
            return this;
        }

        public CourseBuilder withLecturer(String lecturer) {
            this.lecturer = lecturer;
            return this;
        }

        public CourseBuilder withTitle(String title) {
            this.title = title;
            return this;
        }

        public Course build() {
            Course course = new Course();
            course.setId(id);
            course.setFieldOfStudy(fieldOfStudy);
            course.setNumber(number);
            course.setLecturer(lecturer);
            course.setTitle(title);
            return course;
        }
    }

    @Override
    public String toString() {
        return String.format("ID %d | Studiengang %s | Nummer %d | Dozent %s | Titel %s",
                id,
                fieldOfStudy,
                number,
                lecturer,
                title);
    }
}
