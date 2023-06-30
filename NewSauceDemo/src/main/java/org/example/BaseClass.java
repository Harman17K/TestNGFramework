package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * Hello world!
 *
 */
public class BaseClass
{
   WebDriver chromeSetup(WebDriver driver){
       System.setProperty("webdriver.chrome.driver","C:\\Users\\harmsingh\\Desktop\\chromedriver.exe");
       driver = new ChromeDriver();
       driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
       return driver;
   }
}
