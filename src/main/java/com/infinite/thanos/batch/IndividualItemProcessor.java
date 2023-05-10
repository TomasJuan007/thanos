package com.infinite.thanos.batch;

import com.infinite.thanos.model.AbstractIndividual;
import com.infinite.thanos.service.Orb;
import com.infinite.thanos.service.Scepter;
import com.infinite.thanos.service.Tesseract;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IndividualItemProcessor<T extends AbstractIndividual> implements ItemProcessor<T, T> {
    @Autowired
    private Scepter scepter;
    @Autowired
    private Tesseract tesseract;
    @Autowired
    private Orb orb;

    @Override
    public T process(final T individual) {
        individual.accept(scepter);
        individual.accept(tesseract);
        individual.accept(orb);
        if (individual.isMark()) {
            return null;
        }
        return individual;
    }
}
