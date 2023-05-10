package com.infinite.thanos.service.itf;

import com.infinite.thanos.model.Individual;

public interface Visitor {
    void visit(Individual individual);
}
