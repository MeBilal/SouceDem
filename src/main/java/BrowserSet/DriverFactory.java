package BrowserSet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    private static String browserName="Chrome";
    private static WebDriver driver;

    public static void setDriver(){
        if(browserName.equals("Edge")){
            driver=new EdgeDriver();
        } else if (browserName.equals("FireFox")) {
            driver=new FirefoxDriver();

        }else{
            driver=new ChromeDriver();
        }
    }

    public static WebDriver getDriver(){
        return driver;
    }



}
