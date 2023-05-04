package com.infinite.thanos.service.itf;

import com.infinite.thanos.model.Individual;

public interface Orb {
    void produce(Individual individual);
    void consume() throws InterruptedException;
}
