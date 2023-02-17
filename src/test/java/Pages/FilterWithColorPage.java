package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class FilterWithColorPage {

    WebDriver driver;

    public FilterWithColorPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void choseCategories(){
        driver.navigate().to("https://demo.nopcommerce.com/shoes");
    }

    public void filterWithRed(){
        driver.findElement(By.id("attribute-option-15")).click();
    }
}
