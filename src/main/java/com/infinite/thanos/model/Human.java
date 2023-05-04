package com.infinite.thanos.model;

public class Human implements Individual {
    private Long identifier;
    private String firstName;
    private String lastName;

    public Human() {
    }

    public Human(Long identifier, String firstName, String lastName) {
        this.identifier = identifier;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public Long getIdentifier() {
        return identifier;
    }

    @Override
    public void setIdentifier(Long identifier) {
        this.identifier = identifier;
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
        return "Human<identifier: " + identifier + ", firstName: " + firstName + ", lastName: " + lastName + ">";
    }
}
