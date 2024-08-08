package com.rs.basics;


import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public class iOSFindElements {


    public static void main(String[] args) throws Exception {
    AppiumDriver driver = CreateDriverSession.initializeDriver("iOS");

        WebElement myEle= driver.findElement(AppiumBy.accessibilityId("Activity Indicators"));
        System.out.println("element -> " +myEle.getText());
        //myEle.click();

        myEle= driver.findElements(AppiumBy.className("XCUIElementTypeStaticText")).get(1);
        System.out.println("element -> " +myEle.getText());

        myEle= driver.findElement(AppiumBy.id("Activity Indicators"));
        System.out.println("element -> " +myEle.getText());

        myEle= driver.findElement(AppiumBy.name("Activity Indicators"));
        System.out.println("element -> " +myEle.getText());

        myEle= driver.findElement(AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Activity Indicators\"]"));
        System.out.println("element -> " +myEle.getText());

        myEle= driver.findElement(AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Activity Indicators\"]"));
        System.out.println("element -> " +myEle.getText());

        //Locator using predicate string


    }
}
