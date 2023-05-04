package com.infinite.thanos.service;

import com.infinite.thanos.model.Individual;
import com.infinite.thanos.service.itf.Tesseract;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;

@Component
public class TesseractImpl implements Tesseract {

    @Override
    public void allocateID(Individual individual) {
        SecureRandom secureRandom = new SecureRandom();
        individual.setIdentifier(secureRandom.nextLong());
    }
}
