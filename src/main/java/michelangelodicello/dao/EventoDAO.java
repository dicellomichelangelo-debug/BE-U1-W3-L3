package michelangelodicello.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import michelangelodicello.entities.Evento;

import java.util.UUID;

public class EventoDAO {
    private final EntityManager em;

    public EventoDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Evento evento) {
        EntityTransaction t = em.getTransaction();
        try {
            t.begin();
            em.persist(evento);
            t.commit();
        } catch (Exception e) {
            if (t.isActive()) t.rollback();
            throw e;
        }
    }

    public Evento findById(UUID id) {
        return em.find(Evento.class, id);
    }

    public void delete(Evento evento) {
        EntityTransaction t = em.getTransaction();
        try {
            t.begin();
            em.remove(em.contains(evento) ? evento : em.merge(evento));
            t.commit();
        } catch (Exception e) {
            if (t.isActive()) t.rollback();
            throw e;
        }
    }
}
