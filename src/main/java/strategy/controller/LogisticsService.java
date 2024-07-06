package strategy.controller;

import lombok.var;
import strategy.model.Administrator;
import strategy.model.Freight;
import strategy.model.KLM;
import strategy.model.Sedex;

import java.util.Scanner;

public class LogisticsService {
    public static void main(String[] args) {
        final var scanner = new Scanner(System.in);

//        final var authenticationService = new AuthenticationService();
//        final var administrator = new Administrator();
//        System.out.println(administrator.getUsername());

//        final var client = new Client();
//
//        authenticationService.login(client);
//        authenticationService.login(administrator);
//
//        final var distanceInKm = scanner.nextInt();
//        final var transportationId = scanner.nextInt();
//
//        var freight = getFreight(transportationId);
//
//        System.out.println("TOTAL:: " + freight.calcFreight(distanceInKm));
    }

    private static Freight getFreight(int transportationId) {
        Freight freight = new KLM();
        if (transportationId == 1)
            freight = new Sedex();
        return freight;
    }
}
