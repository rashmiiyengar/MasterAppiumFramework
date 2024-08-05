import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class CreateDriverSession {

    public static  AppiumDriver initializeDriver(String platformName) throws Exception {


        UiAutomator2Options uiAutomator2Options = new UiAutomator2Options().
                setPlatformName(platformName).
                setNewCommandTimeout(Duration.ofSeconds(3600));

        URL url = new URL("http://0.0.0.0:4723");

        switch (platformName){
            case "Android":
                uiAutomator2Options.
                        setDeviceName("pixel_8").
                        setUdid("emulator-5554").
                        setAutomationName("UiAutomator2").setAppPackage("io.appium.android.apis").
                        setAppActivity("io.appium.android.apis.ApiDemos");

                //setAvd("Pixel_8").
                //setAvdLaunchTimeout(Duration.ofSeconds(180)).

                String appUrl = System.getProperty("user.dir") + File.separator +"src" +File.separator+ "test" +File.separator+ "java"
                        +File.separator+ "resources" +File.separator+ "ApiDemos-debug.apk";

                return new AndroidDriver(url,uiAutomator2Options);

            case "iOS":
                String appPath =  File.separator + "Users" +
                        File.separator + "rashmisoundar" + File.separator + "Library" + File.separator +
                        "Developer" + File.separator + "Xcode" + File.separator + "DerivedData" + File.separator +
                        "UIKitCatalog-bxkqfsgsxwufspdglqwmlpfkekxx" + File.separator + "Build" + File.separator + "Products" +
                        File.separator + "Debug-iphonesimulator" + File.separator + "UIKitCatalog.app";
                XCUITestOptions xcuiTestOptions = new XCUITestOptions().
                        setDeviceName("iPhone 15 Pro Max").
                        setPlatformName("iOS").
                        setUdid("60E3DF6B-4EE5-4B32-9AB8-B6E6BC8D9620").
                        setAutomationName("XCUITest").
                        setSimulatorStartupTimeout(Duration.ofSeconds(180)).
                        setBundleId("com.example.apple-samplecode.UICatalog");
                //setApp(appPath);
                return  new IOSDriver(url,xcuiTestOptions);

            default:
                throw new Exception("invalid platform");

        }
    }


}
