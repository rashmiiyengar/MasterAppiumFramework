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


    public static void main(String[] args) throws Exception {

        AppiumDriver driver = CreateDriverSession.initializeDriver("Android");

        longClickGesture(driver);


    }
}
