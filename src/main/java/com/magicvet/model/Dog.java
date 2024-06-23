package main.java.com.magicvet.model;

import java.util.Objects;

public class Dog extends Pet {

    private Size size;

    public Dog() { }

    public Dog(Size size) {
        this.size = size;
    }

    public Dog(HealthState healthState) {
        super(healthState);
    }

    public Dog(String type, String sex, int age, String name, HealthState healthState) {
        super(type, sex, age, name, healthState);
    }

    @Override
    public String toString() {
        return "Pet {"
                + "type = " + getType()
                + ", sex = " + getSex()
                + ", age = " + getAge()
                + ", name = " + getName()
                + ", health state = " + getHealthState().getOriginalState()
                + ", size = " + getSize()
                + ", ownerName = " + getOwnerName()
                + ", registrationDate = " + getRegistrationDate().format(FORMATTER)
                + "}";
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Dog dog = (Dog) object;
        return Objects.equals(size, dog.size);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), size);
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public enum Size {
        XS(1),
        S(2),
        M(3),
        L(4),
        XL(5),
        UNKNOWN(0);

        private final int value;

        Size(int value) {
            this.value = value;
        }

        public static Size fromString(String value) {
            for (Size size : values()) {
                if (size.toString().equalsIgnoreCase(value)) {
                    return size;
                }
            }
            System.out.println("Unable to parse value '" + value
                    + "'. Using default value: " + UNKNOWN);

            return UNKNOWN;
        }

        public int getValue() {
            return value;
        }
    }
}