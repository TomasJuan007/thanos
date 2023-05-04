package com.infinite.thanos.service;

import com.infinite.thanos.Application;
import com.infinite.thanos.model.Human;
import com.infinite.thanos.service.itf.Tesseract;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class TesseractImplTest {
    @Autowired
    private Tesseract tesseract;
    @Test
    public void allocateIDTest() {
        Human individual = new Human();
        individual.setFirstName("Kronas");
        individual.setLastName("Kork");
        tesseract.allocateID(individual);
        System.out.println(individual);
        Assert.assertNotNull(individual.getIdentifier());
    }
}
