package pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Zhanna on 26.03.2017.
 */
public class GoodPage extends Page{

    public GoodPage(WebDriver driver){
        super(driver);
    }
    public void addGoodToCart() {
        int count = Integer.parseInt(driver.findElement(By.cssSelector("span.quantity")).getText());
        if(driver.findElements(By.cssSelector("select[name*=options]")).size() > 0){
            Select size = new Select(driver.findElement(By.cssSelector("select[name*=options]")));
            size.selectByVisibleText("Small");
        }
        driver.findElement(By.cssSelector("button[name=add_cart_product]")).click();
        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.cssSelector("span.quantity")), String.valueOf(count+1)));
        driver.findElement(By.cssSelector("img[src*='logotype']")).click();
    }
}
