package de.nordakademie.iaa.hibernate.model;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;

@Entity
public class Room {

    private Long id;
    private String building;
    private Integer roomNumber;
    private Integer seats;
    private Boolean hasPresenter;

    @Id
    @GeneratedValue(strategy = AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NaturalId
    @Column(name = "ROOM_NUMBER")
    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    @NaturalId
    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    @Basic
    @Column(name = "HAS_PRESENTER")
    public Boolean getHasPresenter() {
        return hasPresenter;
    }

    public void setHasPresenter(Boolean hasPresenter) {
        this.hasPresenter = hasPresenter;
    }

    @Basic
    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    public static RoomBuilder roomBuilder() {
        return new RoomBuilder();
    }

    public static final class RoomBuilder {
        private Long id;
        private String building;
        private Integer roomNumber;
        private Integer seats;
        private Boolean hasPresenter;

        private RoomBuilder() {
        }

        public RoomBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public RoomBuilder building(String building) {
            this.building = building;
            return this;
        }

        public RoomBuilder roomNumber(Integer roomNumber) {
            this.roomNumber = roomNumber;
            return this;
        }

        public RoomBuilder seats(Integer seats) {
            this.seats = seats;
            return this;
        }

        public RoomBuilder hasPresenter(Boolean hasPresenter) {
            this.hasPresenter = hasPresenter;
            return this;
        }

        public Room build() {
            Room room = new Room();
            room.setId(id);
            room.setBuilding(building);
            room.setRoomNumber(roomNumber);
            room.setSeats(seats);
            room.setHasPresenter(hasPresenter);
            return room;
        }
    }
}
