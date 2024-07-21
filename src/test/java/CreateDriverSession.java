import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class CreateDriverSession {

    public static void main(String[] args) throws MalformedURLException {

        String appUrl = System.getProperty("user.dir") + File.separator +"src" +File.separator+ "test" +File.separator+ "java"
        +File.separator+ "resources" +File.separator+ "ApiDemos-debug.apk";

        UiAutomator2Options uiAutomator2Options = new UiAutomator2Options().
                setDeviceName("pixel_8").setAutomationName("UiAutomator2").
                setAppPackage("io.appium.android.apis").
                setAppActivity("io.appium.android.apis.media.MediaPlayerDemo");

        URL url = new URL("http://0.0.0.0:4723");

        AppiumDriver driver = new AndroidDriver(url,uiAutomator2Options);
    }
}
