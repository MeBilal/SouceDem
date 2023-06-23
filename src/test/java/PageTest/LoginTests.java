package PageTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.Inventory;
import pages.Login;
import testData.LoginDataProv;
import testFond.BaseTest;

public class LoginTests extends BaseTest {


    @Test
    public void succeLogin(){

       loginS();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");


   }

    @Test(dataProvider = "loginData",dataProviderClass = LoginDataProv.class)
    public void failLogin(String username, String password){

        Assert.assertEquals("Epic sadface: Username and password do not match any user in this service",
                loginPage.loginError(username,password));
    }


}
