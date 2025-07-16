import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@RequestScoped
public class PersistenceController implements Serializable {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("likeHeroToZeroPersistenceUnit");

    public void mergeCountries(CountryList countryList) {
        List<Country> countries = new ArrayList<>(countryList.get());
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        for (Country c : countries) {
            em.merge(c);
        }
        em.getTransaction().commit();
        em.close();
    }
}
