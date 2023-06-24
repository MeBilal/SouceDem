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
    public List<WebElement> productNames(){
        List<WebElement> productNames = driver.findElements(By.className("inventory_item_name"));
        return  productNames;
    }

    public List<WebElement> productPrices(){
        List<WebElement> productPrices = driver.findElements(By.className("inventory_item_price"));
        return  productPrices;
    }


}
