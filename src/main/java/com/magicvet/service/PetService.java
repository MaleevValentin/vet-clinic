package main.java.com.magicvet.service;

import main.java.com.magicvet.Main;
import main.java.com.magicvet.model.Cat;
import main.java.com.magicvet.model.Dog;
import main.java.com.magicvet.model.Pet;

import java.util.InputMismatchException;

import static main.java.com.magicvet.service.ClientService.isNameValid;

public class PetService {

    private static final String DOG_TYPE = "dog";
    private static final String CAT_TYPE = "cat";
    private static final String MALE_TYPE = "male";
    private static final String FEMALE_TYPE = "female";

    public Pet registerNewPet() {
        Pet pet = null;

        System.out.print("Type (dog / cat): ");
        String type = Main.SCANNER.nextLine();

        if (DOG_TYPE.equals(type) || CAT_TYPE.equals(type)) {
            pet = buildPet(type);
        } else {
            System.out.println("Unknown pet type: " + type);
        }

        return pet;
    }

    private Pet buildPet(String type) {
        Pet pet = type.equals(CAT_TYPE) ? new Cat() : new Dog();
        pet.setType(type);

        pet.setAge(getPetAgeInput());
        pet.setName(getPetNameInput());
        pet.setSex(getPetSexInput());

        if (type.equals(DOG_TYPE)) {
            System.out.print("Size (XS / S / M / L / XL): ");
            String size = Main.SCANNER.nextLine();
            ((Dog) pet).setSize(Dog.Size.fromString(size));
        }

        System.out.println("""
                Select your pet's health status:
                                \s
                 AGGRESSIVE
                 PAIN
                 LETHARGIC
                 EXCITED
                 FEAR
                 NORMAL
                 LIVELY
                \s""");
        String state = Main.SCANNER.nextLine();
        pet.setHealthState(Pet.HealthState.fromString(state));

        return pet;
    }

    private static int getPetAgeInput() {
        while (true) {
            System.out.print("Age: ");
            try {
                int age = Main.SCANNER.nextInt();
                Main.SCANNER.nextLine();

                if (age >= 0) {
                    return age;
                } else {
                    System.out.println("Invalid input. Please enter a positive value of age.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a positive value of age.");
                Main.SCANNER.nextLine();
            }
        }
    }

    private static String getPetNameInput() {
        while (true) {
            System.out.print("Name: ");
            String nameInput = Main.SCANNER.nextLine();

            if (isNameValid(nameInput)) {
                return nameInput;
            }
            System.out.println("Provided " + nameInput + " is invalid.");
        }
    }

    private static String getPetSexInput() {
        while (true) {
            System.out.print("Sex (male / female): ");
            String sexType = Main.SCANNER.nextLine();

            if (MALE_TYPE.equalsIgnoreCase(sexType) || FEMALE_TYPE.equalsIgnoreCase(sexType)) {
                return sexType.toLowerCase();
            } else {
                System.out.println("Unknown sex type: " + sexType);
            }
        }
    }
}