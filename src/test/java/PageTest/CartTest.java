package PageTest;

import BrowserSet.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Cart;
import pages.Inventory;
import testFond.BaseTest;

public class CartTest extends BaseTest {

    @Test
    public void testCartPage(){
       Inventory inventory= loginS();
       inventory.addEllementToCart();
      Cart cart= inventory.clickOnShoppingCart();
      cart.clickOnCheckout();





    }
}
