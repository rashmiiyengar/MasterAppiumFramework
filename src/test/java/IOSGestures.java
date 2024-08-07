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


    public static void main(String[] args) throws Exception {

        AppiumDriver driver = CreateDriverSession.initializeDriver("iOS");
        //swipeGesture(driver);

        //scrollGesture(driver);
        //pinchGesture(driver);

        touchAndHold(driver);
    }
}
