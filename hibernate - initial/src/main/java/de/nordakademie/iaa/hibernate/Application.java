package de.nordakademie.iaa.hibernate;

import com.oracle.tools.packager.Log;
import de.nordakademie.iaa.hibernate.model.Room;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;

public class Application {

    public static final Logger LOG = LoggerFactory.getLogger(Application.class);

    public static final void main(String[] args) {
        Long roomId = createRoom();
        LOG.info(String.format("Create room with id %d", roomId));

        Room room = getRoom(roomId);

        LOG.info(String.format("Load room with id %d and name %s%d", roomId, room.getBuilding(), room.getRoomNumber()));

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

        EntityManager entityManager = HibernateUtil.getEntityManagerFactory()
                .createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(room);
        entityManager.getTransaction().commit();

        entityManager.close();

        return room.getId();
    }

    private static Room getRoom(Long roomId) {

        EntityManager entityManager = HibernateUtil.getEntityManagerFactory()
                .createEntityManager();

        return entityManager.find(Room.class, roomId);
    }
}
