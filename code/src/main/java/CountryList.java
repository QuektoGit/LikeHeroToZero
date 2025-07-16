import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@ViewScoped
public class CountryList implements Serializable {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("likeHeroToZeroPersistenceUnit");
    List<Country> countryList = new ArrayList<>();

    @Inject
    private Country tempCountry;
    public Country getTempCountry() {return tempCountry;}
    public void setTempCountry(Country country) {tempCountry = country;}

    public CountryList() {
        EntityManager em = emf.createEntityManager();
        countryList = em.createQuery("select c From Country c", Country.class).getResultList();
        em.close();
    }

    public List<Country> get() {
        return countryList;
    }

    public void add(Country country) {
        countryList.add(country);
    }
}
