package pages;

import BrowserSet.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Inventory {
    public WebDriver driver= DriverFactory.getDriver();
    @FindBy(className = "btn_inventory") private List<WebElement> addCartsbuttons;
    @FindBy(id="react-burger-menu-btn") private WebElement sandButton;
    @FindBy(id="about_sidebar_link") private WebElement about;
    @FindBy(id="logout_sidebar_link") private WebElement logout;
    @FindBy(className = "product_sort_container") private WebElement productSort;
    @FindBy(className = "shopping_cart_link") private WebElement shoppingCartButton;



    public void addCarts(){
        for(WebElement addButton:addCartsbuttons){
            addButton.click();
        }

    }
    public  void addEllementToCart(){
        addCartsbuttons.get(3).click();
    }
    public Cart clickOnShoppingCart(){
        shoppingCartButton.click();
        return PageFactory.initElements(driver,Cart.class);
    }


    public void sandwitchButton(){

        sandButton.click();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("about_sidebar_link")));



    }
    public void aboutClick(){


        about.click();
    }

    public Login logout(){
        logout.click();
        return PageFactory.initElements(driver, Login.class);

    }
    public Inventory selectElement(String option){
        Select productSelect=new Select(productSort);
          productSelect.selectByValue(option);
        return PageFactory.initElements(driver,Inventory.class);

    }
    public boolean areNamesOrderd(String orderType){
        List<WebElement> productNames = driver.findElements(By.className("inventory_item_name"));
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

    public boolean arePricesOrderd(String orderType){
        List<WebElement> productNames = driver.findElements(By.className("inventory_item_price"));
        List<Double> names=new LinkedList<>();
        List<Double> tempNames=new LinkedList<>();
        for(WebElement item: productNames){
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
