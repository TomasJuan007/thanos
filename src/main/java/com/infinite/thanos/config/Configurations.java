package com.infinite.thanos.config;

import com.infinite.thanos.service.OrbImpl;
import com.infinite.thanos.service.itf.Orb;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Configurations {
    @Bean
    public Orb orb(ApplicationContext applicationContext) {
        OrbImpl orb = applicationContext.getBean(OrbImpl.class);
        Thread t = new Thread(orb);
        t.setDaemon(true);
        t.start();
        return orb;
    }
}
