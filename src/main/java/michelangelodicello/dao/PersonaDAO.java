package michelangelodicello.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import michelangelodicello.entities.Persona;

import java.util.UUID;

public class PersonaDAO {
    private final EntityManager em;

    public PersonaDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Persona persona) {
        EntityTransaction t = em.getTransaction();
        try {
            t.begin();
            em.persist(persona);
            t.commit();
        } catch (Exception e) {
            if (t.isActive()) t.rollback();
            throw e;
        }
    }

    public Persona findById(UUID id) {
        return em.find(Persona.class, id);
    }

    public void delete(Persona persona) {
        EntityTransaction t = em.getTransaction();
        try {
            t.begin();
            em.remove(em.contains(persona) ? persona : em.merge(persona));
            t.commit();
        } catch (Exception e) {
            if (t.isActive()) t.rollback();
            throw e;
        }
    }
}