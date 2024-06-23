package main.java.com.magicvet.service;

import main.java.com.magicvet.Main;
import main.java.com.magicvet.model.Client;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClientService {

    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    static final String NAME_PATTERN = "^([A-Z][a-z]{2,}|[A-Z][a-z]{2,}+-[A-Z][a-z]{2,})$";

    public Optional<Client> registerNewClient() {
        Client client = null;

        System.out.println("Please provide client details.");
        System.out.print("Email: ");
        String email = Main.SCANNER.nextLine();

        if (isEmailValid(email)) {
            client = buildClient(email);
            System.out.println("New client: " + client.getFirstName() + " "
                    + client.getLastName() + " ("
                    + client.getEmail() + ")");
        } else {
            System.out.println("Provided email is invalid.");
        }

        return Optional.ofNullable(client);
    }

    private static Client buildClient(String email) {
        Client client = new Client();
        client.setEmail(email);

        client.setFirstName(getUserInput("First name"));
        client.setLastName(getUserInput("Last name"));

        System.out.print("Location (Kyiv / Kharkiv / Lviv / Odesa): ");

        Client.Location location;
        String locationInput = Main.SCANNER.nextLine();

        try {
            location = Client.Location.valueOf(locationInput.toUpperCase());
        } catch (IllegalArgumentException e) {
            location = Client.Location.UNKNOWN;
            System.out.println("Unable to parse value '" + locationInput
                    + "'. Using default value: " + Client.Location.UNKNOWN);
        }

        client.setLocation(location);

        return client;
    }

    private static boolean isEmailValid(String email) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    static boolean isNameValid(String name) {
        Pattern pattern = Pattern.compile(NAME_PATTERN);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }

    private static String getUserInput(String prompt) {
        while (true) {
            System.out.print(prompt + ": ");
            String input = Main.SCANNER.nextLine();
            if (isNameValid(input)) {
                return input;
            }
            System.out.println("Provided " + prompt.toLowerCase() + " is invalid.");
        }
    }
}