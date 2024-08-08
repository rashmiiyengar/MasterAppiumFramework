import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.time.Duration;

public class AndInteractWithKeyboard {

    public static void main(String[] args) throws Exception{

        AppiumDriver driver = CreateDriverSession.initializeDriver("Android");
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        By views = AppiumBy.accessibilityId("Views");
        By textFields = AppiumBy.accessibilityId("TextFields");
        By editText = AppiumBy.id("io.appium.android.apis:id/edit");

        driver.findElement(views).click();

        WebElement element = driver.findElement(AppiumBy.id("android:id/list"));
        boolean isElementFound= false;

        while(!isElementFound){
            if (!driver.findElements(textFields).isEmpty()) {
                // If TextFields element is found
                driver.findElement(textFields).click();
                isElementFound = true;
            } else {
                // Scroll down if the element is not found
                driver.executeScript("mobile: scrollGesture", ImmutableMap.of(
                        "elementId", ((RemoteWebElement) element).getId(),
                        "direction", "down",
                        "percent", 3.0 // Adjust the scroll percentage as needed
                ));
            }
        }

        driver.findElement(editText).click();
        Thread.sleep(3000);

        if(((AndroidDriver) driver).isKeyboardShown()){
            ((AndroidDriver) driver).pressKey(new KeyEvent().withKey(AndroidKey.A));
            ((AndroidDriver) driver).pressKey(new KeyEvent().withKey(AndroidKey.A));
            ((AndroidDriver) driver).pressKey(new KeyEvent().withKey(AndroidKey.A));
        }

        ((AndroidDriver) driver).hideKeyboard();
        Thread.sleep(3000);

    }







}
