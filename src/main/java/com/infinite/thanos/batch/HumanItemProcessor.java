package com.infinite.thanos.batch;

import com.infinite.thanos.model.Human;
import com.infinite.thanos.service.itf.Orb;
import com.infinite.thanos.service.itf.Tesseract;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HumanItemProcessor implements ItemProcessor<Human, Human> {
    @Autowired
    private Tesseract tesseract;
    @Autowired
    private Orb orb;

    @Override
    public Human process(final Human human) {
        tesseract.allocateID(human);
        orb.produce(human);
        if (human.getIdentifier() % 2 != 0) {
            return null;
        }
        return human;
    }
}
