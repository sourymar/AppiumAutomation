package com.brillio.android;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.appmanagement.BaseOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Demo1InstallApp {
    public static void main(String[] args) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName","android");
        capabilities.setCapability("appium:deviceName","Pixel 2 API 30");
        capabilities.setCapability("appium:app","C:\\Users\\diany\\Documents\\SeleniumCertification\\TestCodeSelenium\\AppiumBrillioP1\\mobileApp\\khan-academy-7-3-2.apk");
        //Manually start the Appium server with: 127.0.0.1 and 4723
        AppiumDriver driver = new AppiumDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
        System.out.println(driver.getPageSource());


    }

    public static void androidConfigurationEmulator() throws MalformedURLException {
        //For this we should open Android studio and start a device emulator
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName","android");
        capabilities.setCapability("appium:deviceName","Pixel 2 API 30"); //Name of device started on Android Studio
        capabilities.setCapability("appium:app","C:\\Users\\diany\\Documents\\SeleniumCertification\\TestCodeSelenium\\AppiumBrillioP1\\mobileApp\\khan-academy-7-3-2.apk");
        //Manually start the Appium server with: 127.0.0.1 and 4723
        AppiumDriver driver = new AppiumDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
        System.out.println(driver.getPageSource());
    }

    public static void androidConfigurationRealDevice() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName","android");
        capabilities.setCapability("appium:deviceName","motorola"); //Any device name
        capabilities.setCapability("appium:app","C:\\Users\\diany\\Documents\\SeleniumCertification\\TestCodeSelenium\\AppiumBrillioP1\\mobileApp\\khan-academy-7-3-2.apk");
        //Manually start the Appium server with: 127.0.0.1 and 4723
        AppiumDriver driver = new AppiumDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
        System.out.println(driver.getPageSource());

    }
}
