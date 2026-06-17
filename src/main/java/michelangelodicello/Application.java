package michelangelodicello;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import michelangelodicello.dao.EventoDAO;
import michelangelodicello.dao.LocationDAO;
import michelangelodicello.dao.PartecipazioneDAO;
import michelangelodicello.dao.PersonaDAO;
import michelangelodicello.entities.*;

import java.util.Date;

public class Application {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("be-u1-w3-l3");
        EntityManager em = emf.createEntityManager();

        LocationDAO locationDAO = new LocationDAO(em);
        EventoDAO eventoDAO = new EventoDAO(em);
        PersonaDAO personaDAO = new PersonaDAO(em);
        PartecipazioneDAO partecipazioneDAO = new PartecipazioneDAO(em);

        try {
            Location location = new Location();
            location.setNome("Ippodromo SNAI San Siro");
            location.setCitta("Milano");

            locationDAO.save(location);
            System.out.println("Location salvata con successo con ID: " + location.getId());


            Evento evento = new Evento();
            evento.setTitolo("Summer Rock Festival 2026");
            evento.setDataEvento(new Date());
            evento.setDescrizione("Il festival estivo più atteso dell'anno sotto le stelle.");
            evento.setNumeroMassimoPartecipanti(5000);
            evento.setTipoEvento(TipoEvento.PUBBLICO);
            evento.setLocation(location);

            eventoDAO.save(evento);
            System.out.println("Evento salvato con successo con ID: " + evento.getId());


            Persona persona = new Persona();
            persona.setNome("Alessandro");
            persona.setCognome("Rossi");
            persona.setEmail("alessandro.rossi@email.com");
            persona.setDataDiNascita(new Date(95, 4, 15));
            persona.setSesso(Sesso.UOMO);

            personaDAO.save(persona);
            System.out.println("Persona salvata con successo con ID: " + persona.getId());


            Partecipazione partecipazione = new Partecipazione();
            partecipazione.setPersona(persona);
            partecipazione.setEvento(evento);
            partecipazione.setStato(StatoPartecipazione.CONFERMATA);

            partecipazioneDAO.save(partecipazione);
            System.out.println("Partecipazione creata e registrata con successo con ID: " + partecipazione.getId());


        } catch (Exception e) {
            System.err.println("--- Si è verificato un errore durante l'esecuzione: ---");
        }
    }
}
