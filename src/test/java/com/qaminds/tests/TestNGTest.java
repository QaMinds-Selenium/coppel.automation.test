package com.qaminds.tests;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.*;

@Slf4j
public class TestNGTest {

    @BeforeSuite
    public void BeforeSuite(){
        log.info("Se ejecuto el Before Suite");
    }

    @BeforeTest
    public void BeforeTest(){
        log.info("Se ejecuta el Before Test");
    }

    @Test(priority = 3, dependsOnMethods = "TestFour")
    public void TestOne(){
      log.info("Test One");
    }

    @Test(priority = 2, enabled = false)
    public void TestTwo(){
        log.info("Test Two");
    }

    @Test(priority = 1, dependsOnGroups = "Desktop", alwaysRun = true)
    public void TestThree(){
        log.info("Test Three");
    }

    @Test(priority = 4)
    public void TestFour(){
        log.info("Test Four");
    }

    @Test(priority = 5, groups = "Desktop")
    public void TestFive() throws Exception {
        log.info("Test Five");
        throw new Exception();
    }

    @Test(priority = 6, groups = "Desktop")
    public void TestSix(){
        log.info("Test Six");
    }

    @Test(timeOut = 5000)
    public void TestSeven() throws InterruptedException {
        log.info("Test Seven");
        Thread.sleep(10000);
    }

    @Test(dataProvider = "TestData", dataProviderClass = DataProvider.class)
    public void TestEight(String alumno, int calif){
        log.info("Test Eight");
        log.info(String.format("El alumno %s, tuvo una calificacion de %s", alumno, calif));
    }
}
