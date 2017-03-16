package ru.stqa;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

/**
 * Created by Zhanna on 15.03.2017.
 */
public class AdditionToCart extends TestBase {

    public boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        }
        catch (NoSuchElementException e) {
            return false;
        }
    }
    int count = 0;

    @Test
    public void toCart()throws Exception{
        driver.get("http://localhost/litecart");
        for(int i = 0; i < 3; i++){
            List<WebElement> list = driver.findElements(By.cssSelector("div.middle [class=link]"));
            list.get(0).click();
            if(driver.findElements(By.cssSelector("select[name*=options]")).size() > 0){
                Select size = new Select(driver.findElement(By.cssSelector("select[name*=options]")));
                size.selectByVisibleText("Small");
            }
            driver.findElement(By.cssSelector("button[name=add_cart_product]")).click();
            count = Integer.parseInt(driver.findElement(By.cssSelector("span.quantity")).getText());
            wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.cssSelector("span.quantity")), String.valueOf(count+1)));
            driver.findElement(By.cssSelector("img[src*='logotype']")).click();
        }
        driver.findElement(By.cssSelector("a.link")).click();
        for (int i = 0; i > 3; i++){
            List<WebElement> shortcuts = driver.findElements(By.cssSelector("li.shortcut > a"));
            List<WebElement> remove = driver.findElements(By.cssSelector("button[name*=remove]"));
            shortcuts.get(i).click();
            Thread.sleep(2000);
            remove.get(i).click();
            Thread.sleep(2000);
        }
    }
}
