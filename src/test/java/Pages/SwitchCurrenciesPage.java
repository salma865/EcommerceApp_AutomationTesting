package Pages;

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
}
