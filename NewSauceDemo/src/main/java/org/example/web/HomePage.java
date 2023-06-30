package org.example.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver=driver;
    }

    public void waitForElement(WebElement element){
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(element));
    }

    public void waitUntilElementDisapper(String element){
        new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.invisibilityOfElementLocated(By.className(element)));
    }

    public void add_Sauce_Backpack(){
        WebElement addBackupToCart = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        addBackupToCart.click();
        WebElement remove = driver.findElement(By.id("remove-sauce-labs-backpack"));
        waitForElement(remove);
    }

    public WebElement cartBadge(){
        return driver.findElement(By.className("shopping_cart_badge"));
    }
}
