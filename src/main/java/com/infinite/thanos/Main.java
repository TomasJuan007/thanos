package com.infinite.thanos;

import com.infinite.thanos.model.Person;
import com.infinite.thanos.service.AbstractOrb;
import com.infinite.thanos.service.Orb;

public class Main {
    private static final Person test = new Person("John", "Doe");

    public static void main(String[] args) {
        Main main = new Main();
        for (int i = 0; i < 2; i++) {
            new Thread(main.newRunnableConsumer()).start();
        }
    }


    public Runnable newRunnableConsumer() {
        return new OrbImpl();
    }

    private class OrbImpl extends AbstractOrb implements Orb, Runnable {
        @Override
        public void consume() throws InterruptedException {
            Person person = test;
            System.out.println("============= TAKEN =============");
            System.out.println("First name: " + person.getFirstName());
            System.out.println("Last name: " + person.getLastName());
            System.out.println("============= DEAD =============");
        }
    }
}
