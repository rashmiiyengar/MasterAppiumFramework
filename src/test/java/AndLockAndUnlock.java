import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import java.time.Duration;

public class AndLockAndUnlock {

    public static void main(String[] args) throws Exception {

        AppiumDriver driver = CreateDriverSession.initializeDriver("Android");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //lock the device for given duration
        //((AndroidDriver) driver).lockDevice(Duration.ofSeconds(5));

        ((AndroidDriver) driver).lockDevice(Duration.ofSeconds(5));
        System.out.println(((AndroidDriver) driver).isDeviceLocked());
        ((AndroidDriver) driver).unlockDevice();
    }


    }

//lock, unlock,isDeviceLocked
//Methods available only for android
