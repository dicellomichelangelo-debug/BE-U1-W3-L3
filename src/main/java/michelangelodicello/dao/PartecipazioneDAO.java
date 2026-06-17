package michelangelodicello.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import michelangelodicello.entities.Partecipazione;

import java.util.UUID;

public class PartecipazioneDAO {
    private final EntityManager em;

    public PartecipazioneDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Partecipazione partecipazione) {
        EntityTransaction t = em.getTransaction();
        try {
            t.begin();
            em.persist(partecipazione);
            t.commit();
        } catch (Exception e) {
            if (t.isActive()) t.rollback();
            throw e;
        }
    }

    public Partecipazione findById(UUID id) {
        return em.find(Partecipazione.class, id);
    }

    public void delete(Partecipazione partecipazione) {
        EntityTransaction t = em.getTransaction();
        try {
            t.begin();
            em.remove(em.contains(partecipazione) ? partecipazione : em.merge(partecipazione));
            t.commit();
        } catch (Exception e) {
            if (t.isActive()) t.rollback();
            throw e;
        }
    }
}