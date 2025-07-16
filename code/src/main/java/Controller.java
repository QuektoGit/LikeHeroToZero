import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;

@Named
@RequestScoped
public class Controller implements Serializable {

    @Inject
    private PersistenceController persistenceController;

    public String viewTable() {
        return "index";
    }

    public String login() {
        return "login";
    }


    public String editTable() {
        return "edit";
    }

    public String finishEdit(CountryList countryList) {
        persistenceController.mergeCountries(countryList);
        return "index";
    }
}
