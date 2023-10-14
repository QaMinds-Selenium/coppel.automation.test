package com.qaminds.tests;

public class DataProvider {
    @org.testng.annotations.DataProvider(name = "TestData")
    public Object[][] TestData(){
        return new Object[][] {
                {"Hector", 5},
                {"Alheli", 7},
                {"Salvador", 10},
                {"Brayan", 1}
        };
    }
}
