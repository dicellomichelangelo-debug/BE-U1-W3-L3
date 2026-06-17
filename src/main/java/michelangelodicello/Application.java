package michelangelodicello;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {

    public static void main(String[] args) {

        System.out.println("====== INIZIO GENERAZIONE SCHEMA TABELLE ======");

        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("be-u1-w3-l3");
            EntityManager em = emf.createEntityManager();

            System.out.println("\n====== SCHEMA GENERATO CON SUCCESSO! ======");
            System.out.println("Se leggi i log SQL 'create table' sopra, le tue entità JPA sono strutturate bene.");

            em.close();
            emf.close();
        } catch (Exception e) {
            System.err.println("\n❌ ERRORE CRITICO NELLA MAPPA DELLE ENTITÀ:");
            e.printStackTrace();
        }
    }
}
