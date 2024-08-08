package com.rs.basics;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.HashMap;
import java.util.Map;

public class IOSGestures {

    public static void swipeGesture(AppiumDriver driver){

        WebElement element = driver.findElement(AppiumBy.iOSNsPredicateString("type == \"XCUIElementTypeTable\""));

        Map<String, Object> params = new HashMap<>();
        params.put("direction", "up");
        //params.put("velocity", 2500);
        params.put("elementId", ((RemoteWebElement) element).getId());
        driver.executeScript("mobile: swipe", params);

    }

    public static void scrollGesture(AppiumDriver driver){

        WebElement element = driver.findElement(AppiumBy.iOSNsPredicateString("type == \"XCUIElementTypeTable\""));

        Map<String, Object> params = new HashMap<>();
        params.put("direction", "down");
        //params.put("velocity", 2500);
        params.put("elementId", ((RemoteWebElement) element).getId());
        driver.executeScript("mobile: scroll", params);

    }

    public static void pinchGesture(AppiumDriver driver) throws InterruptedException {

        Thread.sleep(1000);
        driver.findElement(AppiumBy.iOSNsPredicateString("name == \"Not Now\" AND label == \"Not Now\" AND value == \"Not Now\"")).click();
        Thread.sleep(3000);
        Map<String, Object> params = new HashMap<>();
        params.put("scale", 3);
        params.put("velocity", 2.5);
        driver.executeScript("mobile: pinch", params);


        WebElement element = driver.findElement(AppiumBy.iOSNsPredicateString("name == \"ControlContainerViewController.OverlayView\""));


        Map<String, Object> params1 = new HashMap<>();
        params1.put("scale", 0.1);
        params1.put("velocity", -2.2);
        params1.put("elementId", ((RemoteWebElement) element).getId());
        driver.executeScript("mobile: pinch", params1);
    }


    public static void touchAndHold(AppiumDriver driver){

         driver.findElement(AppiumBy.accessibilityId("Steppers")).click();

        Map<String, Object> params = new HashMap<>();

        WebElement element = driver.findElement(AppiumBy.iOSClassChain
                ("**/XCUIElementTypeButton[`name == \"Increment\"`][1]"));
        params.put("elementId", ((RemoteWebElement) element).getId());
        params.put("duration",5);
        driver.executeScript("mobile: touchAndHold", params);

    }

    public static void tapGesture(AppiumDriver driver){

      WebElement element= driver.findElement(AppiumBy.accessibilityId("Steppers"));

        Map<String, Object> params = new HashMap<>();
        params.put("elementId", ((RemoteWebElement) element).getId());
        params.put("x",0);
        params.put("y",0);
        driver.executeScript("mobile: tap", params);

    }

    public static void pickerWheel(AppiumDriver driver){

        driver.findElement(AppiumBy.accessibilityId("Picker View")).click();

        boolean flag= false;
        while (!flag){
            WebElement redPredicateWheel  = driver.findElement(AppiumBy.
                    iOSNsPredicateString("name == \"Red color component value\""));

            Map<String, Object> params = new HashMap<>();
            params.put("order", "next");
            params.put("offset", 0.15);
            params.put("element", ((RemoteWebElement) redPredicateWheel).getId());
            driver.executeScript("mobile: selectPickerWheelValue", params);

            //if you want specific value use a while loop with intented value to be selected
            if(redPredicateWheel.getText().equals("90")){
                flag= true;
            }
        }

        flag= false;
        while (!flag){
            WebElement redPredicateWheel  = driver.findElement(AppiumBy.
                    iOSNsPredicateString("name == \"Green color component value\""));

            Map<String, Object> params = new HashMap<>();
            params.put("order", "previous");
            params.put("offset", 0.15);
            params.put("element", ((RemoteWebElement) redPredicateWheel).getId());
            driver.executeScript("mobile: selectPickerWheelValue", params);

            //if you want specific value use a while loop with intented value to be selected
            if(redPredicateWheel.getText().equals("190")){
                flag= true;
            }
        }


    }



    public static void slidersGestures(AppiumDriver driver){

        driver.findElement(AppiumBy.accessibilityId("Sliders")).click();

        WebElement element= driver.findElement(AppiumBy.iOSNsPredicateString("value == \"42%\""));
        element.sendKeys("0");

    }

    public static void main(String[] args) throws Exception {

        AppiumDriver driver = CreateDriverSession.initializeDriver("iOS");
        //swipeGesture(driver);

        //scrollGesture(driver);
        //pinchGesture(driver);

        //touchAndHold(driver);
        //tapGesture(driver);

        //pickerWheel(driver);

        slidersGestures(driver);
    }
}
