package main.java.com.magicvet.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Client {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("MM/dd/yyyy 'at' hh:mm a");

    private String firstName;
    private String lastName;
    private String email;
    private List<Pet> pets = new ArrayList<>();
    private final LocalDateTime registrationDate = LocalDateTime.now();

    @Override
    public String toString() {
        String message;
        if (!this.pets.isEmpty()) {
            message = "\nClient {"
                    + "\n\tfirstName = " + firstName
                    + ", lastName = " + lastName
                    + ", email = " + email
                    + ", registrationDate = " + registrationDate.format(FORMATTER)
                    + ",\n\tpets: " + pets
                    + "\n}";
        } else {
            message = "\nClient {"
                    + "\n\tfirstName = " + firstName
                    + ", lastName = " + lastName
                    + ", email = " + email
                    + ", registrationDate = " + registrationDate.format(FORMATTER)
                    + ",\n\tpet: not registered"
                    + "\n}";
        }
        return message;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Client client = (Client) object;
        return Objects.equals(firstName, client.firstName)
                && Objects.equals(lastName, client.lastName)
                && Objects.equals(email, client.email)
                && Objects.equals(pets, client.pets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, email, pets);
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public List<Pet> getPet() {
        return pets;
    }

    public void setPet(List<Pet> pets) {
        this.pets = pets;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void addPet(Pet pet) {
        pets.add(pet);
    }
}