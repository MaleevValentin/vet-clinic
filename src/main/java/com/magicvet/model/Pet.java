package main.java.com.magicvet.model;

import java.util.Objects;

public abstract class Pet {

    private String type;
    private String sex;
    private String age;
    private String name;
    private String ownerName;
    private HealthState healthState;

    public Pet() {
    }

    public Pet(HealthState healthState) {
        this.healthState = healthState;
    }

    public Pet(String type, String sex, String age, String name, HealthState healthState) {
        this.type = type;
        this.sex = sex;
        this.age = age;
        this.name = name;
        this.healthState = healthState;
    }

    @Override
    public String toString() {
        return "type = " + type
                + ", sex = " + sex
                + ", age = " + age
                + ", name = " + name
                + ", health state = " + healthState.getOriginalState()
                + ", ownerName = " + ownerName;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Pet pet = (Pet) object;
        return Objects.equals(type, pet.type)
                && Objects.equals(sex, pet.sex)
                && Objects.equals(age, pet.age)
                && Objects.equals(name, pet.name)
                && Objects.equals(ownerName, pet.ownerName)
                && Objects.equals(healthState, pet.healthState);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, sex, age, name, ownerName, healthState);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public HealthState getHealthState() {
        return healthState;
    }

    public void setHealthState(HealthState healthState) {
        this.healthState = healthState;
    }

    public enum HealthState {
        AGGRESSIVE("AGGRESSIVE","Агресивний", 0),
        PAIN("PAIN","Біль", 1),
        LETHARGIC("LETHARGIC","Млявий", 2),
        EXCITED("EXCITED","Збуджений", 3),
        FEAR("FEAR","Страх", 4),
        NORMAL("NORMAL","Нормальний", 5),
        LIVELY("LIVELY","Жвавий", 6);

        private final String originalState;
        private final String ukrTranslation;
        private final int value;

        HealthState(String originalState, String ukrTranslation, int value) {
            this.originalState = originalState;
            this.ukrTranslation = ukrTranslation;
            this.value = value;
        }

        public String getOriginalState() {
            return originalState;
        }

        public String getUkrTranslation() {
            return ukrTranslation;
        }

        public int getValue() {
            return value;
        }
    }
}