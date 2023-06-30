package org.example.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage extends CartPage{

    WebDriver driver;
    public CheckoutPage(WebDriver driver){
        super(driver);
        this.driver=driver;
    }

    public WebElement Continue(){
        return driver.findElement(By.id("continue"));
    }

    public WebElement Finish(){
        return driver.findElement(By.id("finish"));
    }

    public void fillCheckoutPage(String firstName, String lastName, String postalCode){
        driver.findElement(By.id("first-name")).sendKeys(firstName);
        driver.findElement(By.id("last-name")).sendKeys(lastName);
        driver.findElement(By.id("postal-code")).sendKeys(postalCode);
    }

    public WebElement ThanksForOrderMessage(){
        return driver.findElement(By.xpath("//*[normalize-space()=\"Thank you for your order!\"]"));
    }
}
