package de.nordakademie.iaa.hibernate.persistence;

import de.nordakademie.iaa.hibernate.HibernateUtil;
import de.nordakademie.iaa.hibernate.model.Room;

import javax.persistence.EntityManager;

public class RoomPersistence {

    public static Long saveRoom(Room room) {
        EntityManager entityManager = HibernateUtil.getEntityManagerFactory()
                .createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(room);
        entityManager.getTransaction().commit();

        entityManager.close();

        return room.getId();
    }

    public static Room loadRoom(Long roomId) {
        EntityManager entityManager = HibernateUtil.getEntityManagerFactory()
                .createEntityManager();

        return entityManager.find(Room.class, roomId);
    }

    public static void updateRoom(Long id, int seats, boolean hasPresenter) {
        EntityManager entityManager = HibernateUtil.getEntityManagerFactory()
                .createEntityManager();

        entityManager.getTransaction().begin();

        Room room = entityManager.find(Room.class, id);

        room.setSeats(seats);
        room.setHasPresenter(hasPresenter);

        entityManager.getTransaction().commit();
    }

    public static Room deleteRoom(Long id) {
        EntityManager entityManager = HibernateUtil.getEntityManagerFactory()
                .createEntityManager();

        entityManager.getTransaction().begin();
        Room room = entityManager.find(Room.class, id);

        entityManager.remove(room);
        entityManager.getTransaction().commit();

        return room;
    }

}
