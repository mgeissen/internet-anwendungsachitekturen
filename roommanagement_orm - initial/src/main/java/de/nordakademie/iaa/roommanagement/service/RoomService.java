package de.nordakademie.iaa.roommanagement.service;

import de.nordakademie.iaa.roommanagement.dao.LectureDAO;
import de.nordakademie.iaa.roommanagement.dao.RoomDAO;
import de.nordakademie.iaa.roommanagement.model.Room;

import javax.inject.Inject;
import javax.persistence.PersistenceContext;
import java.util.List;

public class RoomService {

    private RoomDAO roomDAO;

    @Inject
    public void setRoomDAO(RoomDAO roomDAO) {
        this.roomDAO = roomDAO;
    }

    public Room saveRoom(Room room) {
        return roomDAO.saveRoom(room);
    }

    public List<Room> listRooms() {
        return roomDAO.listRooms();
    }

    public void deleteRoom(long roomId) {
        roomDAO.deleteRoom(roomId);
    }

    public Room loadRoom(long roomId) {
        return roomDAO.loadRoom(roomId);
    }
}