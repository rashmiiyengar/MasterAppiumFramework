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
    public static void main(String[] args) throws Exception {

        AppiumDriver driver = CreateDriverSession.initializeDriver("iOS");
        //swipeGesture(driver);

        scrollGesture(driver);

    }
}
