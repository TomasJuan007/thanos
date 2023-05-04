package com.infinite.thanos.service;

import com.infinite.thanos.model.Individual;
import com.infinite.thanos.service.itf.Orb;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.invoke.MethodHandles;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class OrbImpl extends AbstractOrb implements Orb, Runnable {
    private static final Logger logger = LoggerFactory.getLogger(OrbImpl.class);
    private final Map<Long, Individual> orbContainer = new ConcurrentHashMap<>();

    @Override
    public void produce(Individual individual) {
        orbContainer.put(individual.getIdentifier(), individual);
    }

    @Override
    public void consume() {
        orbContainer.forEach((identifier, individual) -> {
            if (identifier % 2 != 0) {
                logger.info("individual[{}] is taken.", individual);
                orbContainer.remove(identifier);
                logger.info("individual[{}] is terminated.", individual);
            }
        });
    }
}
