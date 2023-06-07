package com.brillio.androidcloud;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Demo2Test {
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

        AppiumDriver driver = new AppiumDriver(new URL("http://hub.browserstack.com/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        System.out.println(driver.getPageSource());

        driver.quit();
    }
}