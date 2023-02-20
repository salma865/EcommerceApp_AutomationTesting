package Pages;

import org.junit.Assert;
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

    public void validation() throws InterruptedException {
        String expectedResult = "https://demo.nopcommerce.com/shoes?viewmode=grid&orderby=0&pagesize=6&specs=15";
        String actualResult = driver.getCurrentUrl();
        Assert.assertTrue(actualResult.contains(expectedResult));
        Thread.sleep(1000);
        driver.quit();
    }
}
