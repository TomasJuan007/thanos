package com.infinite.thanos.service;

public abstract class AbstractOrb implements Orb, Runnable {
    @Override
    public void run() {
        while (true) {
            try {
                consume();
            } catch (Exception e) {
                e.printStackTrace();
                break;
            }
        }
    }
}
