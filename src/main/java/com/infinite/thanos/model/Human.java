package com.infinite.thanos.model;

public class Human extends AbstractIndividual {
    private String firstName;
    private String lastName;

    public Human() {
    }

    public Human(Long identifier, String firstName, String lastName) {
        super.setIdentifier(identifier);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Human<identifier: " + super.getIdentifier() + ", firstName: " + firstName + ", lastName: " + lastName + ">";
    }
}
