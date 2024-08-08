package com.rs.basics;

import com.rs.basics.CreateDriverSession;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;

import java.io.File;

public class IosInteractingWithApps {

    public static void main(String[] args) throws Exception {

        AppiumDriver driver = CreateDriverSession.initializeDriver("iOS");

        String appPath =  File.separator + "Users" +
                File.separator + "rashmisoundar" + File.separator + "Library" + File.separator +
                "Developer" + File.separator + "Xcode" + File.separator + "DerivedData" + File.separator +
                "UIKitCatalog-bxkqfsgsxwufspdglqwmlpfkekxx" + File.separator + "Build" + File.separator + "Products" +
                File.separator + "Debug-iphonesimulator" + File.separator + "UIKitCatalog.app";

        driver.findElement(AppiumBy.accessibilityId("Activity Indicators")).click();

        Thread.sleep(2000);
        ((IOSDriver) driver).terminateApp("com.example.apple-samplecode.UICatalog");

        //((IOSDriver) driver).installApp(appPath);

        //((IOSDriver) driver).runAppInBackground(Duration.ofSeconds(5));

        ((IOSDriver) driver).activateApp("com.apple.Preferences");
        Thread.sleep(2000);
        ((IOSDriver) driver).activateApp("com.example.apple-samplecode.UICatalog");
    }
}
