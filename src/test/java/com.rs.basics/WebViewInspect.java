package com.rs.basics;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

public class WebViewInspect {

    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.initializeDriver("Android");

        By views = AppiumBy.accessibilityId("Views");
        driver.findElement(views).click();

        By webView = AppiumBy.accessibilityId("WebView2");

        WebElement element = driver.findElement(AppiumBy.id("android:id/list"));
        boolean isElementFound= false;

        while(!isElementFound){
            if (!driver.findElements(webView).isEmpty()) {
                // If TextFields element is found
                driver.findElement(webView).click();
                isElementFound = true;
            } else {
                // Scroll down if the element is not foundwebView
                driver.executeScript("mobile: scrollGesture", ImmutableMap.of(
                        "elementId", ((RemoteWebElement) element).getId(),
                        "direction", "down",
                        "percent", 3.0 // Adjust the scroll percentage as needed
                ));
            }
        }

        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"This page is a Second Selenium sandbox\")")).getText();

    }
}
