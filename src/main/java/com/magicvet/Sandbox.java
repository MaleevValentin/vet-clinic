package main.java.com.magicvet;

import main.java.com.magicvet.comparator.DogSizeComparator;
import main.java.com.magicvet.comparator.PetAgeComparator;
import main.java.com.magicvet.comparator.PetNameComparator;
import main.java.com.magicvet.model.Cat;
import main.java.com.magicvet.model.Dog;
import main.java.com.magicvet.model.Pet;

import java.util.Arrays;

public class Sandbox {

    public static void main(String[] args) {
        Dog[] dogs = {
            new Dog(Dog.M),
            new Dog(Dog.S),
            new Dog(Dog.XL),
            new Dog(Dog.XL),
            new Dog(Dog.XS),
            new Dog(Dog.S)
        };

        Arrays.sort(dogs, new DogSizeComparator());
        for (Dog dog : dogs) {
            System.out.println(dog.getSize());
        }

        System.out.println("\n----------\n");

        Pet[] pets = {
                new Cat("cat", "female", "13", "Buffy"),
                new Dog("dog", "male", "3", "Bob"),
                new Cat("cat", "female", "11", "Ann"),
                new Dog("dog", "male", "1", "John"),
                new Cat("cat", "male", "2", "Rich"),
                new Dog("dog", "female", "6", "Leslie"),
                new Cat("cat", "male", "8", "Den"),
                new Dog("dog", "male", "5", "Tor"),
        };

        Arrays.sort(pets, new PetAgeComparator());
        for (Pet pet : pets) {
            System.out.println(pet.getAge());
        }

        System.out.println("\n----------\n");

        Arrays.sort(pets, new PetNameComparator());
        for (Pet pet : pets) {
            System.out.println(pet.getName());
        }
    }

}
