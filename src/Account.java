import java.util.Scanner;

public class Account {

        double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    // einzahlung geld
    void deposit(double amount) {
        if (amount != 0) {
            balance = balance + amount;

        }
    }

    // Auszahlung geld
    void withdraw (double amount) {
        if (amount != 0) {
            balance = balance - amount;
        }
    }
    void showMenu() {
        char option = '\0';
        Scanner scanner = new Scanner (System.in);
        System.out.println("B A N K O M A T EOS-Bank Standort: Hamburg");
        System.out.println("Willkommen!");
        System.out.println();
        System.out.println("Was moechten Sie gerne tun?");
        System.out.println();
        System.out.println("A - Kontostand abfragen");
        System.out.println("B - Einzahlen");
        System.out.println("C - Auszahlen");
        System.out.println("D - System verlassen");


        do {
            System.out.println();
            System.out.println("Waehlen sie ein Option: ");
            char option1 = scanner.next().charAt(0);
            option = Character.toUpperCase(option1);
            System.out.println();

            switch (option) {
                // erlaubt das guthaben zu zeigen
                case 'A' -> System.out.println("Kontostand = " + balance);

                // erlaubt guthaben einzuzahlen
                case 'B' -> {
                    System.out.println("Geldbetrag eingeben um einzuzahlen: ");
                    double amount = scanner.nextDouble();
                    deposit(amount);
                    System.out.println();
                    System.out.println("Erfolgreiche Einzahlung!");
                }
                // Geld auszahlen
                case 'C' -> {
                    System.out.println("Geldbetrag eingeben um Geld abzuheben: ");
                    double amount2 = scanner.nextDouble();
                    withdraw(amount2);
                    System.out.println();
                    System.out.println("Erfolgreiche Abhebung!");
                }

                // Account verlassen
                case 'D' -> System.out.println("====================================");


                // default case für falsche eingaben
                default -> System.out.println("Fehler: Sie haben eine Falsche Taste gedrueckt! Bitte A,B,C oder D eingeben!");
            }


        } while (option != 'D');
        System.out.println("Danke fuer das benutzen der EOS-Bank Hamburg!");
    }


}
