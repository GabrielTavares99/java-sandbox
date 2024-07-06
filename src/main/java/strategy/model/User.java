package strategy.model;

import lombok.Getter;


public abstract class User {

    private String password;
    private String username;

    public String getPassword() {
        return "*******";
    }

    public String getUsername() {
        return "VIM DA SUPER";
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
