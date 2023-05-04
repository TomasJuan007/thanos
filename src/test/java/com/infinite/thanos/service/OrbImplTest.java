package com.infinite.thanos.service;

import com.infinite.thanos.model.Human;
import org.junit.Test;

public class OrbImplTest {
    private final Human test = new Human(0L,"John", "Doe");
    private final Human test1 = new Human(1L,"Jim", "Doe");
    private final Human test2 = new Human(2L,"John", "Ma");

    @Test
    public void start() throws InterruptedException {
        OrbImpl orb = new OrbImpl();
        orb.produce(test);
        orb.produce(test1);
        orb.produce(test2);
        new Thread(orb).start();
        Thread.sleep(2000L);
    }
}
