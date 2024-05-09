package main.java.com.magicvet.model;

public class Cat extends Pet{

    public Cat() { }

    public Cat(HealthState healthState) {
        super(healthState);
    }

    public Cat(String type, String sex, String age, String name, HealthState healthState) {
        super(type, sex, age, name, healthState);
    }
}
