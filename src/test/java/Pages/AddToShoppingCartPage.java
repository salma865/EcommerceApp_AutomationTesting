package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AddToShoppingCartPage {
    WebDriver driver;

    public AddToShoppingCartPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void validate_search(){
        String expectedResult = "https://demo.nopcommerce.com/search?q=Portable+Sound+Speakers";
        String actualResult = driver.getCurrentUrl();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }

    public void addToCart(){
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div/div/div[2]/div[3]/div[2]/button[1]")).click();
    }

    public void checkCart() throws InterruptedException {
        driver.findElement(By.className("cart-label")).click();
        String expected = "Portable Sound Speakers";
        String productName = driver.findElement(By.className("product-name")).getText();
        Assert.assertTrue(productName.contains(expected));
        Thread.sleep(2000);
        driver.quit();

    }
}
