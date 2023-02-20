package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SwitchCurrenciesPage {
    WebDriver driver;

    public SwitchCurrenciesPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void switchToEuro(){
        Select c = new Select(driver.findElement(By.name("customerCurrency")));
        //c.selectByValue("Euro");
        c.selectByVisibleText("Euro");
    }

    public void switchToUS(){
        Select c = new Select(driver.findElement(By.name("customerCurrency")));
        //c.selectByValue("US Dollar");
        c.selectByVisibleText("US Dollar");
    }

    public void validateCurrencyIsEuro() throws InterruptedException {
        String expectedResult = "€";
        String actualResult = driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div/div/div[2]/div[3]/div[1]/span")).getText();
        Assert.assertTrue(actualResult.contains(expectedResult));
        Thread.sleep(1000);
        driver.quit();
    }

    public void validateCurrencyIsUS() throws InterruptedException {
        String expectedResult = "$";
        String actualResult = driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div/div/div[2]/div[3]/div[1]/span")).getText();
        Assert.assertTrue(actualResult.contains(expectedResult));
        Thread.sleep(1000);
        driver.quit();
    }
}
