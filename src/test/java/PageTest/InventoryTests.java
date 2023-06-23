package PageTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Inventory;
import testFond.BaseTest;

public class InventoryTests extends BaseTest {
    private Inventory inventory;

   //@Test
    public void testAddButton() {
        inventory=loginS();
        inventory.addCarts();

    }
   @Test
    public void testAbout(){
        inventory=loginS();
        inventory.sandwitchButton();
        inventory.aboutClick();
        Assert.assertEquals("https://saucelabs.com/", driver.getCurrentUrl());
    }

    @Test
    public void testLogout(){
        inventory=loginS();
        inventory.sandwitchButton();
       inventory.logout();
       Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
    }
   @Test
    public void testProductSortingAZ(){
       inventory=loginS();
       inventory.selectElement("az");
       Assert.assertEquals(inventory.areNamesOrderd("az"),true);

    }
    @Test
    public void testProductSortingZA(){
        inventory=loginS();
        inventory.selectElement("za");
        Assert.assertEquals(inventory.areNamesOrderd("za"),true);

    }

    @Test
    public void testProductSortinglohi(){
        inventory=loginS();
        inventory.selectElement("lohi");
        Assert.assertEquals(inventory.arePricesOrderd("lohi"),true);

    }
    @Test
    public void testProductSortinghilo(){
        inventory=loginS();
        inventory.selectElement("hilo");
        Assert.assertEquals(inventory.arePricesOrderd("hilo"),true);

    }

}
