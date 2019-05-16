package com.infinite.thanos.service;

import com.infinite.thanos.model.Person;
import org.junit.Test;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class OrbImplTest {
    private Person test = new Person("John", "Doe");
    private Person test1 = new Person("Jim", "Doe");
    private Person test2 = new Person("John", "Ma");
    private Map<String, Person> orbContainer = new ConcurrentHashMap<>();

    @Test
    public void start() throws InterruptedException {
        orbContainer.putIfAbsent(UUID.randomUUID().toString(), test);
        orbContainer.putIfAbsent(UUID.randomUUID().toString(), test1);
        orbContainer.putIfAbsent(UUID.randomUUID().toString(), test2);

        Runnable orbImpl = new OrbImpl(orbContainer);
        new Thread(orbImpl).start();
        Thread.sleep(5000L);
    }
}
