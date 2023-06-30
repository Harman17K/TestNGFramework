package org.example;


import org.example.web.CheckoutPage;
import org.example.web.HomePage;
import org.example.web.LoginPage;
import org.openqa.selenium.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SauceDemoTest extends BaseClass{

    WebDriver driver;
    String BASE_URL="https://www.saucedemo.com/";
    LoginPage loginPage;
    HomePage homePage;
    CheckoutPage checkoutPage;

    @BeforeMethod
    void Setup(){
        driver = chromeSetup(driver);
        driver.get(BASE_URL);
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        checkoutPage = new CheckoutPage(driver);
    }

    @AfterMethod
    void cleanup(){
        driver.quit();
    }


    @Test
    void test_Valid_SignIn_Flow(){

        loginPage.SignIn();
    }

    @Test
    void test_Invalid_SignIn_Flow(){
        String errorText= "Username and password do not match";
        WebElement username = driver.findElement(By.id("user-name"));
        loginPage.waitForElement(username);
        username.sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("invalid_password");
        driver.findElement(By.id("login-button")).click();
        loginPage.waitForElement(driver.findElement(By.xpath("//*[contains(text(),'" + errorText + "')]")));
    }

    @Test
    void test_Add_To_Cart_Check(){
        loginPage.SignIn();
        homePage.add_Sauce_Backpack();
        homePage.waitForElement(driver.findElement(By.className("shopping_cart_badge")));
    }

    @Test
    void test_Remove_Button_Functionality(){
        loginPage.SignIn();
        homePage.add_Sauce_Backpack();
        driver.findElement(By.id("remove-sauce-labs-backpack")).click();
        homePage.waitUntilElementDisapper("shopping_cart_badge");
    }

    @Test
    void validateItemCheckout() {
        loginPage.SignIn();
        homePage.add_Sauce_Backpack();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement cart = driver.findElement(By.className("shopping_cart_link"));
        js.executeScript("arguments[0].scrollIntoView()", cart);
        if(homePage.cartBadge().isDisplayed()){
            homePage.cartBadge().click();
        }
        else{
            throw new NoSuchElementException("Cart notifier not present");
        }
        checkoutPage.clickCheckout();
        checkoutPage.fillCheckoutPage("Harman","K","123456");
        checkoutPage.Continue().click();
        checkoutPage.Finish().click();
        checkoutPage.ThanksForOrderMessage().isDisplayed();
    }
}
