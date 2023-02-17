package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class SelectCategoryPage {
    WebDriver driver;
    List<WebElement> Categories;
    List<WebElement> SubCategories;
    String category;

    public SelectCategoryPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void getCategories() {
        Categories = driver.findElements(By.xpath("/html/body/div[6]/div[2]/ul[1]/li"));
    }

    public void SelectCategory(){
        //select random category
        Random num = new Random();
        getCategories();
        int selected = num.nextInt(Categories.size());
        Actions action = new Actions(driver);
        WebElement selectedCategory = Categories.get(selected);
        //hover
        action.moveToElement(selectedCategory);
        SubCategories = selectedCategory.findElements(By.cssSelector("ul>li"));
        //open sub-Category if found or the selected category
        if(SubCategories.size() != 0){
            Random num2 = new Random();
            int subSelected = num2.nextInt(SubCategories.size());
            WebElement selectedSubCategory = SubCategories.get(subSelected);
            action.moveToElement(selectedSubCategory);
            category = selectedSubCategory.getText();
            selectedSubCategory.click();
        }
        else{
            category = selectedCategory.getText();
            selectedCategory.click();
        }
    }

    public void validation(){
        //page title
        String actualResult = driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[1]/h1")).getText();
        Assert.assertTrue(actualResult.contains(category));
    }
}
