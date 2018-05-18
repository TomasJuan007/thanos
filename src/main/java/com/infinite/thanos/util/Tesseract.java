package com.infinite.thanos.util;

import com.infinite.thanos.model.Individual;
import com.infinite.thanos.model.Species;

import java.util.ArrayList;
import java.util.List;

public class Tesseract {
    public static List<Species> getAllSpecies() {
        List<Species> speciess = new ArrayList<Species>();
        Species demo = new Species();
        List<Individual> individuals = new ArrayList<Individual>();
        Individual individual = new Individual();
        individuals.add(individual);
        demo.setIndividuals(individuals);
        speciess.add(demo);
        return speciess;
    }
}
