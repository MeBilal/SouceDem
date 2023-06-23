package testFond;

import BrowserSet.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.Inventory;
import pages.Login;

public class BaseTest {
    public WebDriver driver;
    public Login loginPage;
    @BeforeMethod
    public void beforTestStart(){
        DriverFactory.setDriver();
        driver = DriverFactory.getDriver();
        driver.navigate().to("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        loginPage=startTest();
    }
    @AfterMethod
    public void afterTest(){
        driver.close();
    }
    public Login startTest(){
        return PageFactory.initElements(driver, Login.class);
    }
    public  Inventory loginS(){
      return   loginPage.loginSu("standard_user","secret_sauce");
    }

}
