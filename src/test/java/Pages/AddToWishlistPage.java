package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AddToWishlistPage {
    WebDriver driver;

    public AddToWishlistPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void addToWishlist(){
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div/div/div[2]/div[3]/div[2]/button[3]")).click();
    }

    public void checkWishlist(){
        driver.findElement(By.className("wishlist-label")).click();
        String expected = "Ray Ban Aviator Sunglasses";
        String productName = driver.findElement(By.className("product-name")).getText();
        Assert.assertTrue(productName.contains(expected));
    }
}
