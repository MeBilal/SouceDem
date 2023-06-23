package PageTest;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Cart {
    @FindBy(id="checkout")
    WebElement checkOut;

    public void clickOnCheckout(){
        checkOut.click();
    }
}
