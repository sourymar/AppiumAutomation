package com.brillio.android;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Demo2NativeAppTest {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName","android");
        capabilities.setCapability("appium:deviceName","motorola");
        capabilities.setCapability("appium:app","C:\\Users\\diany\\Documents\\SeleniumCertification\\TestCodeSelenium\\AppiumBrillioP1\\mobileApp\\khan-academy-7-3-2.apk");
        //Manually start the Appium server with: 127.0.0.1 and 4723
        AppiumDriver driver = new AppiumDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Descartar']")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Iniciar sesión']")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Iniciar sesión']")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[contains(@text,'Introduce')]")).sendKeys("john@gmail.com");
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[contains(@text,'Contraseña')]")).sendKeys("john123");
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc='Iniciar sesión']/android.widget.TextView")).click();
        assertTrue(driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Hubo un error al iniciar sesión']")).isDisplayed(),"Verifying the erro message was displayed");

        driver.quit();
    }
}
