package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SelectTagsPage {
    WebDriver driver;

    public SelectTagsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void selectTag(String tagName){
        if(tagName.contains("awesome")) {
            driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[1]/div[3]/div[2]/div[1]/ul/li[2]")).click();
        }
    }

    public void validation(String tagName){
        if(tagName.contains("awesome")) {
            String expectedResult = "Products tagged with 'awesome'";
            String actualResult = driver.findElement(By.className("page-title")).getText();
            Assert.assertTrue(actualResult.contains(expectedResult));
        }
    }
}
