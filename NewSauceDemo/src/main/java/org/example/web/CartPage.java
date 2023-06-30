package org.example.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {
    WebDriver driver;
    public CartPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickCheckout(){
        WebElement checkout = driver.findElement(By.id("checkout"));
        checkout.isDisplayed();
        checkout.click();
    }

}
