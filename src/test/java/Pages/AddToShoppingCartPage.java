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

    public void addToCart(){
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div/div/div[2]/div[3]/div[2]/button[1]")).click();
    }

    public void checkCart(){
        driver.findElement(By.className("cart-label")).click();
        String expected = "Portable Sound Speakers";
        String productName = driver.findElement(By.className("product-name")).getText();
        Assert.assertTrue(productName.contains(expected));

    }
}
