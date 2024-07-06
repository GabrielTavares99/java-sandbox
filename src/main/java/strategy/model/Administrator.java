package strategy.model;

public class Administrator extends User {

    public Administrator(String username, String password) {
        super.setUsername(username);
        super.setPassword(password);
    }

    @Override
    public String getUsername() {
        return "ADM " + super.getUsername();
    }
}
