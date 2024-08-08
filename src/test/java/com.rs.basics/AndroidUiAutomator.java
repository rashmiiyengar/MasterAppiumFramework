package com.rs.basics;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AndroidUiAutomator {

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='Accessibility']")
    @iOSXCUITFindBy(accessibility ="accessibility")
    private WebElement accessibilityElement;

    public  AndroidUiAutomator(AppiumDriver driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    public static void main(String[] args) throws Exception {

        AppiumDriver driver = CreateDriverSession.initializeDriver("Android");
        AndroidUiAutomator androidUiAutomator = new AndroidUiAutomator(driver);


        WebElement webElement = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Accessibility\")"));
        System.out.println(webElement.getText());

        webElement = driver.findElements(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.TextView\")")).get(2);
        System.out.println(webElement.getText());

        webElement = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().description(\"Accessibility\")"));
        System.out.println(webElement.getText());

        By myEle = By.xpath("//android.widget.TextView[@content-desc=\"Access'ibility\"]");
        System.out.println(driver.findElement(myEle).getText());


        //
        System.out.println(androidUiAutomator.accessibilityElement.getText());


        //Using By class
        //By myElement1= AppiumBy.androidUIAutomator("");


    }
}
