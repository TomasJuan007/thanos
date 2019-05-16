package com.infinite.thanos.util;

import com.infinite.thanos.model.Person;
import com.infinite.thanos.model.Species;
import com.infinite.thanos.service.OrbImpl;
import org.junit.Test;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TesseractTest {
    @Test
    public void getAllSpeciesTest() {
        Map<String, Species> all = Tesseract.getAllSpecies();
        all.forEach((k, v) -> System.out.println(k));

        Map<String, Person> orbContainer = new ConcurrentHashMap();
        all.forEach((k, v) -> {
            orbContainer.put(k, (Person) v.getIndividuals().get(0));
        });
        new Thread(new OrbImpl(orbContainer)).start();
    }
}
