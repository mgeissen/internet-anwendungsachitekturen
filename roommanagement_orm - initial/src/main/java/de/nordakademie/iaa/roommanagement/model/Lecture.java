package de.nordakademie.iaa.roommanagement.model;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

import static javax.persistence.GenerationType.AUTO;

@Entity
public class Lecture {

    private Long id;
    private Course course;
    private Room room;
    private Date startDate;
    private Date endDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lecture lecture = (Lecture) o;
        return Objects.equals(id, lecture.id) &&
                Objects.equals(course, lecture.course) &&
                Objects.equals(room, lecture.room) &&
                Objects.equals(startDate, lecture.startDate) &&
                Objects.equals(endDate, lecture.endDate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, course, room, startDate, endDate);
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Id
    @GeneratedValue(strategy = AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @ManyToOne
    @NaturalId
    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @NaturalId
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date date) {
        this.startDate = date;
    }

    public static LectureBuilder builder() {
        return new LectureBuilder();
    }



    public static final class LectureBuilder {
        private Long id;
        private Course course;
        private Room room;
        private Date startDate;
        private Date endDate;

        private LectureBuilder() {
        }

        public LectureBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public LectureBuilder withCourse(Course course) {
            this.course = course;
            return this;
        }

        public LectureBuilder withRoom(Room room) {
            this.room = room;
            return this;
        }

        public LectureBuilder withStartDate(Date startDate) {
            this.startDate = startDate;
            return this;
        }

        public LectureBuilder withEndDate(Date endDate) {
            this.endDate = endDate;
            return this;
        }

        public Lecture build() {
            Lecture lecture = new Lecture();
            lecture.setId(id);
            lecture.setCourse(course);
            lecture.setRoom(room);
            lecture.setStartDate(startDate);
            lecture.setEndDate(endDate);
            return lecture;
        }
    }

    @Override
    public String toString() {
        return "Lecture{" +
                "id=" + id +
                ", course=" + course +
                ", room=" + room +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
