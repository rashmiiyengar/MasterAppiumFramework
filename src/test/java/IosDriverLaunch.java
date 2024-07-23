import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class IosDriverLaunch {

    //com.example.apple-samplecode.UICatalog -buildid

    ///Users/rashmisoundar/Library/Developer/Xcode/DerivedData/
    // Users/rashmisoundar/Library/Developer/Xcode/DerivedData/UIKitCatalog-bxkqfsgsxwufspdglqwmlpfkekxx/Build/Products/Debug-iphonesimulator/UIKitCatalog.app

    // Path to the .app file
    String appPath =  File.separator + "Users" +
            File.separator + "rashmisoundar" + File.separator + "Library" + File.separator +
            "Developer" + File.separator + "Xcode" + File.separator + "DerivedData" + File.separator +
            "UIKitCatalog-bxkqfsgsxwufspdglqwmlpfkekxx" + File.separator + "Build" + File.separator + "Products" +
            File.separator + "Debug-iphonesimulator" + File.separator + "UIKitCatalog.app";

    XCUITestOptions xcuiTestOptions = new XCUITestOptions().
            setDeviceName("iPhone 15 Pro Max").setPlatformName("iOS").
            setAutomationName("XCUITest").
            setUdid("60E3DF6B-4EE5-4B32-9AB8-B6E6BC8D9620").setApp(appPath);


           // setBundleId("com.example.apple-samplecode.UICatalog");


    // Define the Appium server URL
    URL url;

    // Declare the Appium driver
    AppiumDriver driver;

    // Constructor to initialize the driver
    public IosDriverLaunch() throws MalformedURLException {
        url = new URL("http://0.0.0.0:4723");
        driver = new IOSDriver(url, xcuiTestOptions);
    }

    // Add a main method to run the driver launch
    public static void main(String[] args) {
        try {
            new IosDriverLaunch();
            System.out.println("iOS Driver launched successfully");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

}
