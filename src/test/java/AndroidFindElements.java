import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;


public class AndroidFindElements {

    public static void main(String[] args) throws Exception {

        AppiumDriver driver = CreateDriverSession.initializeDriver("Android");

        WebElement myEle= driver.findElement(AppiumBy.accessibilityId("Accessibility"));
        System.out.println("element -> " +myEle.getText());

        myEle= driver.findElements(AppiumBy.className("android.widget.TextView")).get(2);
        System.out.println("element -> " +myEle.getText());

        myEle= driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Accessibility\"]"));
        System.out.println("element -> " +myEle.getText());

        myEle= driver.findElement(AppiumBy.xpath("//*[@text=\"Accessibility\"]"));
        System.out.println("element -> " +myEle.getText());








    }
}
