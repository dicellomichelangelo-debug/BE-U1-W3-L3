package michelangelodicello;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {

    public static void main(String[] args) {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("be-u1-w3-l3");
            EntityManager em = emf.createEntityManager();
            System.out.println("--- SCHEMA GENERATO CON SUCCESSO ---");
        } catch (Exception e) {
            System.err.println("--- ERRORE NELLA MAPPA DELLE ENTITÀ: ---");
            e.printStackTrace();
        }
    }
}
