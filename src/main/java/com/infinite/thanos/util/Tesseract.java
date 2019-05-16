package com.infinite.thanos.util;

import com.infinite.thanos.model.Individual;
import com.infinite.thanos.model.Person;
import com.infinite.thanos.model.Species;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class Tesseract {
    private static Map<String, Species> orbContainer = new ConcurrentHashMap<>();

    public static Map<String, Species> getAllSpecies() {
        Species demo = new Species();
        List<Individual> individuals = new ArrayList<Individual>();
        Person individual = new Person();
        individual.setFirstName("Kronas");
        individual.setLastName("Kork");
        individuals.add(individual);
        demo.setIndividuals(individuals);
        orbContainer.put(UUID.randomUUID().toString(), demo);
        return orbContainer;
    }
}
