package pages;

import BrowserSet.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.Inventory;

public class Cart {
    WebDriver driver= DriverFactory.getDriver();
    @FindBy(id="checkout") private WebElement checkOut;
    @FindBy(id="continue-shopping") private WebElement continueShoping;

    public void clickOnCheckout(){
        checkOut.click();
    }
    public Inventory clickOnContinueShoping(){
        continueShoping.click();
        return PageFactory.initElements(driver,Inventory.class);
    }
}
