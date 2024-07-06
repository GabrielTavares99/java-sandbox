package strategy.view;

import lombok.var;
import strategy.controller.AuthenticationService;
import strategy.model.Administrator;

import java.util.Scanner;

public class AuthView {
    public static void main(String[] args) {
        final var scanner = new Scanner(System.in);
        System.out.println("TYPE LOGIN");
        final var login = scanner.next();
        System.out.println("TYPE PASSWORD");
        final var password = scanner.next();

        final var administrator = new Administrator(login, password);
        final var authenticationService = new AuthenticationService();
        final var loginSuccess = authenticationService.login(administrator);

        System.out.println("LOGIN SUCCESS? " + loginSuccess);
    }
}
