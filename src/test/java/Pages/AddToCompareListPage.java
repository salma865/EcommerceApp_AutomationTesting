package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AddToCompareListPage {
    WebDriver driver;

    public AddToCompareListPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void validate_search(){
        String expectedResult = "https://demo.nopcommerce.com/search?q=Science+%26+Faith";
        String actualResult = driver.getCurrentUrl();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }

    public void addToCompareList(){
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div/div/div[2]/div[3]/div[2]/button[2]")).click();
    }

    public void validation() throws InterruptedException {
        String expectedResult = "The product has been added to your product comparison";
        String actualResult = driver.findElement(By.className("content")).getText();
        Assert.assertTrue(actualResult.contains(expectedResult));
        Thread.sleep(2000);
        driver.quit();
    }
}
