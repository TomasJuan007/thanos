package com.infinite.thanos.service;

import com.infinite.thanos.model.Individual;
import com.infinite.thanos.service.itf.Visitor;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;

@Component
public class Tesseract implements Visitor {

    @Override
    public void visit(Individual individual) {
        SecureRandom secureRandom = new SecureRandom();
        individual.setIdentifier(secureRandom.nextLong());
    }
}
