import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.component.UIInput;
import jakarta.faces.context.FacesContext;
import jakarta.faces.event.ComponentSystemEvent;
import jakarta.faces.validator.ValidatorException;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@SessionScoped
public class LoginController implements Serializable {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("likeHeroToZeroPersistenceUnit");

    @Inject
    private User currentUser;
    public User getCurrentUser() {return currentUser;}
    public void setCurrentUser(User currentUser) {}

    List<User> userList = new ArrayList<>();

    public LoginController() {
        EntityManager em = emf.createEntityManager();
        userList = em.createQuery("select u From User u", User.class).getResultList();
        em.close();
    }

    public void postValidateName(ComponentSystemEvent event) {
        UIInput input = (UIInput) event.getComponent();
        currentUser.setUsername((String)input.getValue());
    }

    public void validateLogin(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        currentUser.setPassword((String)value);
        for(User user : userList) {
            if(currentUser.getUsername().equals(user.getUsername()) && currentUser.getPassword().equals(user.getPassword())) {
                return;
            }
        }
        throw new ValidatorException(new FacesMessage("Login Falsch!"));
    }
}
