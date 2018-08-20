package de.nordakademie.iaa.hibernate;

import de.nordakademie.iaa.hibernate.model.Room;
import de.nordakademie.iaa.hibernate.persistence.RoomPersistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Application {

    public static final Logger LOG = LoggerFactory.getLogger(Application.class);

    public static final void main(String[] args) {
        Long roomId = createRoom();
        LOG.info(String.format("Create room with id %d", roomId));

        Room room = RoomPersistence.loadRoom(roomId);

        LOG.info(String.format("Load room with id %d and name %s%d", roomId, room.getBuilding(), room.getRoomNumber()));

        RoomPersistence.updateRoom(room.getId(), 33, false);

        Room newRoom = RoomPersistence.loadRoom(room.getId());

        LOG.info(String.format("Room with seats %d and hasPresenter: %s", newRoom.getSeats(), newRoom.getHasPresenter()));

        HibernateUtil.getEntityManagerFactory()
                .close();
    }

    private static Long createRoom() {
        Room room = Room.roomBuilder()
                .building("A")
                .roomNumber(1)
                .hasPresenter(true)
                .seats(20)
                .build();

        return RoomPersistence.saveRoom(room);
    }

}
