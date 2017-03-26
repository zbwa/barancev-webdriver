package pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by Zhanna on 26.03.2017.
 */
public class CheckoutPage extends Page{

    public CheckoutPage(WebDriver driver){
        super(driver);
    }
    public void deleteFew() {
        int goods = driver.findElements(By.cssSelector("li.shortcut > a")).size();
       for (int i = 0; i < goods; i++) {
            List<WebElement> dataTable = driver.findElements(By.cssSelector("td.item"));
            if (driver.findElements(By.cssSelector("li.shortcut > a")).size() > 0) {
                List<WebElement> shortcuts = driver.findElements(By.cssSelector("li.shortcut > a"));
                shortcuts.get(i).click();
            }
            List<WebElement> remove = driver.findElements(By.cssSelector("button[name*=remove]"));
            remove.get(0).click();
            wait.until(ExpectedConditions.stalenessOf(dataTable.get(0)));
        }
    }

    public void deleteOne() {
        driver.findElement(By.cssSelector("button[name*=remove]")).click();
        wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.cssSelector("td.item"))));
    }
}
