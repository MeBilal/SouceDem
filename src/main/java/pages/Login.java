package pages;

import BrowserSet.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Login {
    WebDriver driver= DriverFactory.getDriver();
    @FindBy(name="user-name") private WebElement userName;
    @FindBy(name="password") private WebElement password;
    @FindBy(id="login-button") private WebElement login;
    @FindBy(className = "error-message-container") private WebElement errorMEssage;


    public Inventory loginSu(String username, String password){
        login(username,password);
        return PageFactory.initElements(driver, Inventory.class);
    }

    public String loginError(String username,String password){
         login(username,password);
        return errorMEssage.getText();
    }
    private void login(String username, String password){
        this.userName.sendKeys(username);
        this.password.sendKeys(password);
        login.click();
    }


}
