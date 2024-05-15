package main.java.com.magicvet;

import main.java.com.magicvet.comparator.PetAgeComparator;
import main.java.com.magicvet.comparator.PetNameComparator;
import main.java.com.magicvet.model.Cat;
import main.java.com.magicvet.model.Dog;
import main.java.com.magicvet.model.Pet;

import java.util.Arrays;
import java.util.Comparator;

public class Sandbox {

    public static void main(String[] args) {
        Dog[] dogs = {
            new Dog(Dog.Size.M),
            new Dog(Dog.Size.S),
            new Dog(Dog.Size.XL),
            new Dog(Dog.Size.XL),
            new Dog(Dog.Size.L),
            new Dog(Dog.Size.XS),
            new Dog(Dog.Size.S)
        };

        Arrays.sort(dogs, new Comparator<Dog>() {
            @Override
            public int compare(Dog o1, Dog o2) {
                return o1.getSize().getValue() - o2.getSize().getValue();
            }
        });

        System.out.println("\nSort by dog size:");
        for (Dog dog : dogs) {
            System.out.println(dog.getSize());
        }

        Pet[] pets = {
                new Cat("cat", "female", "13", "Buffy", Pet.HealthState.NORMAL),
                new Dog("dog", "male", "3", "Bob", Pet.HealthState.PAIN),
                new Cat("cat", "female", "11", "Ann", Pet.HealthState.LETHARGIC),
                new Dog("dog", "male", "1", "John", Pet.HealthState.EXCITED),
                new Cat("cat", "male", "2", "Rich", Pet.HealthState.LIVELY),
                new Dog("dog", "female", "6", "Leslie", Pet.HealthState.AGGRESSIVE),
                new Cat("cat", "male", "8", "Den", Pet.HealthState.FEAR),
                new Dog("dog", "male", "5", "Tor", Pet.HealthState.PAIN),
        };

        System.out.println("\nSort by pet age:");
        Arrays.sort(pets, new PetAgeComparator());
        for (Pet pet : pets) {
            System.out.println(pet.getAge());
        }

        System.out.println("\nSort by pet name:");
        Arrays.sort(pets, new PetNameComparator());
        for (Pet pet : pets) {
            System.out.println(pet.getName());
        }

        Pet[] newPets = {
                new Cat(Pet.HealthState.PAIN),
                new Dog(Pet.HealthState.LETHARGIC),
                new Cat(Pet.HealthState.AGGRESSIVE),
                new Dog(Pet.HealthState.FEAR),
                new Dog(Pet.HealthState.EXCITED),
                new Cat(Pet.HealthState.NORMAL),
                new Dog(Pet.HealthState.LETHARGIC),
                new Dog(Pet.HealthState.LIVELY),
                new Dog(Pet.HealthState.AGGRESSIVE),
                new Dog(Pet.HealthState.PAIN),
        };

        Arrays.sort(newPets, new Comparator<Pet>() {
            @Override
            public int compare(Pet o1, Pet o2) {
                return o1.getHealthState().getValue() - o2.getHealthState().getValue();
            }
        });

        System.out.println("\nSort by priority of helping pets:");
        for (Pet pet : newPets) {
            System.out.println(pet.getHealthState().getOriginalState());
        }

        System.out.println("\nTesting registration date:");
        System.out.println(new Cat());
    }
}