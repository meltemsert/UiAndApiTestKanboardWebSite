package tests;

import drivers.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.PropertyManager;

import java.net.MalformedURLException;

public class KanboardUiTest {
    public static WebDriver driver;

    Driver webDriver=new Driver();
    PropertyManager propertyManager=new PropertyManager();
    String url= propertyManager.getProperty("APP_URL");

    @BeforeMethod(alwaysRun = true)
    public void beforeTest() throws MalformedURLException {
        driver= webDriver.initializeDriver();
        driver.get(url);
    }
    @Test
    public void loginPageTest(){

        WebElement usernameInput=driver.findElement(new By.ByXPath("//*[@id=\"form-username\"]"));
        usernameInput.sendKeys("admin");

        WebElement passwordInput=driver.findElement(new By.ByXPath("//*[@id=\"form-password\"]"));
        passwordInput.sendKeys("admin");

        WebElement clickSignInButton= driver.findElement(new By.ByXPath("//button[contains(text(),'Sign in')]"));
        clickSignInButton.click();
    }
    @AfterMethod(alwaysRun = true)
    public void afterTest(){
        webDriver.quitDriver();
    }
}
