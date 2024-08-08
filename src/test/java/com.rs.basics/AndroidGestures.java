package com.rs.basics;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AndroidGestures {


    public static void longClickGesture(AppiumDriver driver){

        By views = AppiumBy.accessibilityId("Views");
        By dragAndDrop = AppiumBy.accessibilityId("Drag and Drop");

        driver.findElement(views).click();

        //explicit waits
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(dragAndDrop)).click();

        WebElement ele = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));

        //element id recommeneded
       driver.executeScript("mobile: longClickGesture", ImmutableMap.of(
                //"elementId", ((RemoteWebElement) ele).getId(),
               "x",206,
               "y",614,
               "duration",1000
        ));
    }

    public static  void clickGesture(AppiumDriver driver){
        WebElement element = driver.findElement(AppiumBy.accessibilityId("Views"));

        driver.executeScript("mobile: clickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId()
        ));

    }

    public static  void dragGesture(AppiumDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Views"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("Drag and Drop"))).click();

        WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("io.appium.android.apis:id/drag_dot_1")));

        driver.executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) ele).getId(),
                "endX", 623,
                "endY", 623
        ));

    }


    public static void pinchOpenGesture(AppiumDriver driver) throws InterruptedException {

        Thread.sleep(5000);
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Skip\"]")).click();
        //driver.findElement(AppiumBy.accessibilityId("Close"));
        Thread.sleep(5000);

        driver.executeScript("mobile: pinchOpenGesture", ImmutableMap.of(
                "left",200,
                "top",470,
                "width",600,
                "height",600,
                "percent", 0.75
        ));

    }

    public static void swipe(AppiumDriver driver) {

        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();

        WebElement element =driver.findElement(AppiumBy.xpath("//*[@resource-id=\"io.appium.android.apis:id/gallery\"]/android.widget.ImageView[1]\n"));


        driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
             //   "left", 100, "top", 100, "width", 200, "height", 200,
                "elementId",((RemoteWebElement) element).getId(),
                "direction", "left",
                "percent", 0.75
        ));
    }

    public static void scroll(AppiumDriver driver) {

        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        WebElement element = driver.findElement(AppiumBy.id("android:id/list"));

        boolean canScrollMore = (Boolean) driver.executeScript("mobile: scrollGesture", ImmutableMap.of(
               // "left", 100, "top", 100, "width", 200, "height", 200,
                "elementId",((RemoteWebElement) element).getId(),
                "direction", "down",
                "percent", 1.0
        ));
    }


    public static void main(String[] args) throws Exception {

        AppiumDriver driver = CreateDriverSession.initializeDriver("Android");

        //longClickGesture(driver);
        //clickGesture(driver);
        //dragGesture(driver);
        //pinchOpenGesture(driver);
        //swipe(driver);
        scroll(driver);
    }
}
