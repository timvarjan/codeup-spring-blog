package springblog.services;

import org.springframework.security.core.context.SecurityContextHolder;
import springblog.models.User;

public class AuthBuddy {
    public static User getLoggedInUser() {
        User loggedInUser = new User();
        Object thing = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
        if(thing instanceof String || ((User) thing).getId() == 0) {
            loggedInUser.setUsername("Not logged in");
            return loggedInUser;
        }
        loggedInUser = (User) thing;
        return loggedInUser;
    }
}
