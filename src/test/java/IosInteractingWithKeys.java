import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class IosInteractingWithKeys {

    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.initializeDriver("iOS");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement element = driver.findElement(AppiumBy.
                iOSNsPredicateString("type == \"XCUIElementTypeTable\""));
        Map<String, Object> params = new HashMap<>();
        params.put("direction", "up");
        params.put("element", ((RemoteWebElement) element).getId());
        driver.executeScript("mobile: swipe", params);

        driver.findElement(AppiumBy.accessibilityId("Text Fields")).click();
        driver.findElement(AppiumBy.xpath("//XCUIElementTypeCell [1]/XCUIElementTypeTextField")).click();
        Thread.sleep(3000);

        driver.findElement(AppiumBy.accessibilityId("q")).click();
        driver.findElement(AppiumBy.accessibilityId("w")).click();
        driver.findElement(AppiumBy.accessibilityId("e")).click();
        Thread.sleep(3000);
//        ((IOSDriver) driver).hideKeyboard();
        //    driver.getKeyboard().pressKey(Keys.DO); - > Deprecated
        //      driver.findElement(MobileBy.AccessibilityId("Done")).click();


    }
}
