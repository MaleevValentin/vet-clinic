package main.java.com.magicvet;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    static String PASSWORD = "default";
    static Scanner SCANNER = new Scanner(System.in);

    static String EMAIL_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    static String NAME_PATTERN = "^([A-Z][a-z]{2,}|[A-Z][a-z]{2,}+-[A-Z][a-z]{2,})$";

    public static void main(String[] args) {
        run();
    }

    static void run() {
        if (auth()) {
            registerNewClient();
        }
    }

    static boolean auth() {
        boolean accepted = false;
        for (int i = 0; i < 3; i++) {
            System.out.print("Password: ");
            String input = SCANNER.nextLine();

            if (PASSWORD.equals(input)) {
                accepted = true;
                break;
            } else {
                System.out.println("Access denied. Please check your password.");
            }
        }

        System.out.println(accepted ? "Welcome to the Magic Vet!" : "Application has been blocked.");

        return accepted;
    }

    static void registerNewClient() {
        System.out.println("Please provide client details.");
        System.out.print("Email: ");
        String email = SCANNER.nextLine();

        if (isEmailValid(email)) {
            Client client = buildClient(email);
            System.out.println("New client: " + client.firstName + " " + client.lastName + " (" + client.email + ")");
        } else {
            System.out.println("Provided email is invalid.");
        }
    }

    static Client buildClient(String email) {
        Client client = new Client();
        client.email = email;

        client.firstName = getUserInput("First name");
        client.lastName = getUserInput("Last name");

        return client;
    }

    static boolean isEmailValid(String email) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    static boolean isNameValid(String name) {
        Pattern pattern = Pattern.compile(NAME_PATTERN);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }

    static String getUserInput(String prompt) {
        while (true) {
            System.out.print(prompt + ": ");
            String input = SCANNER.nextLine();
            if (isNameValid(input)) {
                return input;
            } else {
                System.out.println("Provided " + prompt.toLowerCase() + " is invalid.");
            }
        }
    }
}