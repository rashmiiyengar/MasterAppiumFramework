package com.rs.basics;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class FetchElementAttributes {

    public static void main(String[] args) throws Exception {

        AppiumDriver driver = CreateDriverSession.initializeDriver("Android");
        By views = AppiumBy.accessibilityId("Views");

        System.out.println(driver.findElement(views).getText());
        System.out.println(driver.findElement(views).getAttribute("text"));
        System.out.println(driver.findElement(views).getAttribute("resource-id"));
        System.out.println(driver.findElement(views).getAttribute("package"));

        System.out.println(driver.findElement(views).isSelected());
        System.out.println(driver.findElement(views).isDisplayed());
        System.out.println(driver.findElement(views).isEnabled());

    }

}
