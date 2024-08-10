package com.qa.mobile;

import org.testng.annotations.Test;
import org.testng.annotations.*;


public class MyTest {


    @BeforeClass
    public void setUp() {
        // Code to set up the test environment
        System.out.println("Setting up...");
    }

    @Test
    public void testMethod() {
        // Your test code here
        System.out.println("Running test method...");
    }

    @AfterClass
    public void tearDown() {
        // Code to clean up after tests
        System.out.println("Cleaning up...");
    }


}
