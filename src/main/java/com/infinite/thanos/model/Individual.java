package com.infinite.thanos.model;

import com.infinite.thanos.service.itf.Visitor;

public interface Individual {
    Long getIdentifier();

    void setIdentifier(Long identifier);

    boolean isMark();

    void setMark(boolean mark);

    String toString();

    void accept(Visitor visitor);
}
