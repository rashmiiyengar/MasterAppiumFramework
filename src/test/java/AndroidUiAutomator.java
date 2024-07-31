import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AndroidUiAutomator {

    public static void main(String[] args) throws Exception {


        AppiumDriver driver = CreateDriverSession.initializeDriver("Android");

        WebElement webElement = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Accessibility\")"));
        System.out.println(webElement.getText());

         webElement = driver.findElements(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.TextView\")")).get(2);
        System.out.println(webElement.getText());

        //Using By class
        //By myElement1= AppiumBy.androidUIAutomator("");


    }

}
