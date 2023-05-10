package com.infinite.thanos.service;

import com.infinite.thanos.model.Individual;
import com.infinite.thanos.service.itf.Visitor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Orb implements Visitor {
    private static final Logger logger = LoggerFactory.getLogger(Orb.class);

    @Override
    public void visit(Individual individual) {
        if (individual.getIdentifier() % 2 != 0) {
            individual.setMark(true);
            logger.info("Marked individual[{}].", individual);
        }
    }
}
