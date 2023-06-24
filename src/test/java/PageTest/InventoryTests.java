package PageTest;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Inventory;
import testFond.BaseTest;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

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
       List<WebElement> productNames=inventory.productNames();
       Assert.assertEquals(isProductsNamesSorted("az", productNames),true);

    }
    @Test
    public void testProductSortingZA(){
        inventory=loginS();
        inventory.selectElement("za");
        List<WebElement> productNames=inventory.productNames();
        Assert.assertEquals(isProductsNamesSorted("za", productNames),true);

    }

    @Test
    public void testProductSortinglohi(){
        inventory=loginS();
        inventory.selectElement("lohi");
        List<WebElement> productPrices=inventory.productPrices();
        Assert.assertEquals(arePricesOrderd("lohi", productPrices),true);

    }
    @Test
    public void testProductSortinghilo(){
        inventory=loginS();
        inventory.selectElement("hilo");
        List<WebElement> productPrices=inventory.productPrices();
        Assert.assertEquals(arePricesOrderd("hilo", productPrices),true);

    }

    public boolean isProductsNamesSorted(String orderType, List<WebElement> productNames){
        List<String> names=new LinkedList<>();
        List<String> tempNames=new LinkedList<>();
        for(WebElement item: productNames){
            names.add(item.getText());
            tempNames.add(item.getText());
        }
        if(orderType.equals("az")){
            Collections.sort(tempNames);
            for(int i=0; i<names.size();i++){
                if(!tempNames.get(i).equals(names.get(i))){

                    return false;
                }

            }
        }else if(orderType.equals("za")){
            Collections.sort(tempNames);
            Collections.reverse(tempNames);
            for(int i=0; i<names.size();i++){
                if(!tempNames.get(i).equals(names.get(i))){

                    return false;
                }

            }

        }



        return true;
    }
    public  boolean arePricesOrderd(String orderType, List<WebElement> productsPrices){
        List<Double> names=new LinkedList<>();
        List<Double> tempNames=new LinkedList<>();
        for(WebElement item: productsPrices){
            String newStr = item.getText().replaceAll("[$,]", "");
            names.add(Double.parseDouble(newStr));
            tempNames.add(Double.parseDouble(newStr));
        }
        if(orderType.equals("lohi")){
            Collections.sort(tempNames);
            for(int i=1; i<names.size();i++){
                if(!tempNames.get(i).equals(names.get(i))){

                    return false;
                }
            }
        }else if(orderType.equals("hilo")){
            Collections.sort(tempNames);
            Collections.reverse(tempNames);
            for(int i=0; i<names.size();i++){
                if(!tempNames.get(i).equals(names.get(i))){

                    return false;
                }

            }

        }





        return true;

    }

}
