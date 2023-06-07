package com.brillio.androidcloud;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Demo3SignUpTest {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName","android");
        capabilities.setCapability("platformVersion","12.0");
        capabilities.setCapability("appium:deviceName","Samsung Galaxy S22 Ultra");
        capabilities.setCapability("app","bs://605efdab6b611b73a0aaf2dc3107056a70accb02");

        HashMap<String,String> bstackDetails = new HashMap<String,String>();
        bstackDetails.put("projectName","BrillioProject");
        bstackDetails.put("buildName","BrillioBuild");
        bstackDetails.put("sessionName","BrillioSession");
        bstackDetails.put("userName","dianaluciahernan_k4SPve");
        bstackDetails.put("accessKey","1jf1oyTExmLHjvhsUdyK");



        capabilities.setCapability("bstack:options", bstackDetails);

        //Manually start the Appium server with: 127.0.0.1 and 4723
        AppiumDriver driver = new AppiumDriver(new URL("http://hub.browserstack.com/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Dismiss']")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Sign in']")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.Button[contains(@text,'Sign up with email')]")).click();

        driver.findElement(AppiumBy.xpath("//android.widget.EditText[contains(@text,'First name')]")).sendKeys("Diana");
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[contains(@text,'Last name')]")).sendKeys("Martinez");
        //driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc='Birthday']/android.widget.TextView")).click();
        //driver.findElement(AppiumBy.id("android:id/button1")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[contains(@text,'Email address')]")).sendKeys("martinez@gmail.com");
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[contains(@text,'Password')]")).sendKeys("test111");


        driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc='Sign in']/android.widget.TextView")).click();
        assertTrue(driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='There was an issue signing in']")).isDisplayed(),"Verifying the erro message was displayed");


        driver.quit();
    }
}
