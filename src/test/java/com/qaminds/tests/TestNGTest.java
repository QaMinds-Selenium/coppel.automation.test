package com.qaminds.tests;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
@Slf4j
public class TestNGTest {

    @DataProvider(name = "TestData")
    public Object[][] testData(){
        return new Object[][]{
                {"Hector", 5},
                {"Alheli", 7},
                {"Salvador", 10},
                {"Brayan", 1},
        };
    }

    @Test(priority = 3, dependsOnGroups = "Desktop")
    public void testOne(){
        log.info("Test One");
    }
    @Test(enabled = false, priority = 2)
    public void testTwo(){
        log.info("Test Two");
    }
    @Test(priority = 1, dependsOnGroups = "Desktop")
    public void testThree(){
        log.info("Test Three");
    }
    @Test(priority = 4)
    public void testFour(){
        log.info("Test Four");
    }
    @Test(priority = 5, groups = "Desktop")
    public void testFive(){
        log.info("Test Five");
    }
    @Test(priority = 6, groups = "Desktop")
    public void testSix(){
        log.info("Test Six");
    }
    @Test
    public void testSeven(){
        log.info("Test Seven");
    }
    @Test(dataProvider = "TestData")
    public void testEight(String alumno, int calif){
        log.info("Test Eight");
        log.info(String.format("El alumno %s, tuvo una calificacion de %s", alumno,calif));
    }
}
