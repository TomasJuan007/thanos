package com.infinite.thanos.model;

import com.infinite.thanos.service.itf.Visitor;

public abstract class AbstractIndividual implements Individual {
    private Long identifier;
    private boolean mark;

    @Override
    public Long getIdentifier() {
        return identifier;
    }

    @Override
    public void setIdentifier(Long identifier) {
        this.identifier = identifier;
    }

    @Override
    public boolean isMark() {
        return mark;
    }

    @Override
    public void setMark(boolean mark) {
        this.mark = mark;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
