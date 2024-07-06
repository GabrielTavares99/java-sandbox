package strategy.controller;

import strategy.model.User;

public class AuthenticationService {
    public boolean login(User user) {
        return !user.getPassword().isEmpty() && !user.getUsername().isEmpty();
    }
}
