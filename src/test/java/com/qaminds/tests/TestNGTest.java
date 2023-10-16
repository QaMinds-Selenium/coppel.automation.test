package com.qaminds.tests;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

@Slf4j
public class TestNGTest {

    @Test(testName = "Test 1", priority= 3, dependsOnMethods = "test4")
    public void test1(){
        log.info("Test one");
    }

    @Test(testName = "Test 2", priority = 2, enabled = false)
    public void test2(){
        log.info("Test two");
    }

    @Test(testName = "Test 3", priority = 1)
    public void test3(){
        log.info("Test three");
    }

    @Test
    public void test4(){
        log.info("Test Four");
    }

}
