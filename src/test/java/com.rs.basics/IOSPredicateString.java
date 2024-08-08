package com.rs.basics;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public class IOSPredicateString {

    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.initializeDriver("iOS");

        WebElement myEle= driver.findElement(AppiumBy.iOSNsPredicateString("type ==\"XCUIElementTypeStaticText\" AND name == \"Activity Indicators\""));
        System.out.println("element -> " +myEle.getText());

        myEle= driver.findElement(AppiumBy.iOSNsPredicateString("name CONTAINS \"Activity Indicators\""));
        System.out.println("element -> " +myEle.getText());




    }
}
