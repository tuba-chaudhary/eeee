package com.example.tests; 
 
import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.WebElement; 
import org.openqa.selenium.chrome.ChromeDriver; 
import org.testng.Assert; 
import org.testng.annotations.BeforeMethod; 
import org.testng.annotations.Test; 
 
public class LoginTest { 
    WebDriver driver; 
    @BeforeMethod 
    public void setUp() { 
        // Initialize ChromeDriver 
        driver = new ChromeDriver(); 
        driver.manage().window().maximize(); 
    } 
     
    @Test 
    public void testSuccessfulLogin() { 
        // Navigate to login page (example using demo site) 
        driver.get("https://www.saucedemo.com/"); 
         
        // Enter credentials 
        WebElement username = driver.findElement(By.id("user-name")); 
        WebElement password = driver.findElement(By.id("password")); 
        WebElement loginButton = driver.findElement(By.id("login-button")); 
         
        username.sendKeys("standard_user"); 
        password.sendKeys("secret_sauce"); 
 
try { 
            Thread.sleep(2000); // wait 2 seconds 
        } catch (InterruptedException e) { 
            e.printStackTrace(); 
        } 
 
        loginButton.click(); 
         
        // Verify successful login by checking URL or page element 
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html")); 
    } 
   
} 
