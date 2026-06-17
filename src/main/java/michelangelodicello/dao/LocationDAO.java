package michelangelodicello.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import michelangelodicello.entities.Location;

import java.util.UUID;

public class LocationDAO {
    private final EntityManager em;

    public LocationDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Location location) {
        EntityTransaction t = em.getTransaction();
        try {
            t.begin();
            em.persist(location);
            t.commit();
        } catch (Exception e) {
            if (t.isActive()) t.rollback();
            throw e;
        }
    }

    public Location findById(UUID id) {
        return em.find(Location.class, id);
    }


    public void delete(Location location) {
        EntityTransaction t = em.getTransaction();
        try {
            t.begin();
            em.remove(em.contains(location) ? location : em.merge(location));
            t.commit();
        } catch (Exception e) {
            if (t.isActive()) t.rollback();
            throw e;
        }
    }
}
