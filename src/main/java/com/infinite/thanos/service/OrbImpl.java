package com.infinite.thanos.service;

import com.infinite.thanos.model.Person;

import java.util.Map;

public class OrbImpl  extends AbstractOrb implements Orb, Runnable {
    private Map<String, Person> orbContainer;

    public OrbImpl(Map orbContainer) {
        this.orbContainer = orbContainer;
    }

    @Override
    public void consume() {

        orbContainer.forEach( (uuid, person) -> {
            System.out.println(person.getFirstName() + " " +person.getLastName() + " is taken. ");
            orbContainer.remove(uuid);
            System.out.println(person.getFirstName() + " " +person.getLastName() + " is killed. ");
        });
    }
}
