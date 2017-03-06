package ru.stqa;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by Zhanna on 25.02.2017.
 */
public class LoginTestAdministrator extends TestBase{
    public boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @Test
    public void loginTest()throws Exception{
        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        int size = driver.findElements(By.cssSelector("li#app-")).size();
        List<WebElement> list;
        for (int i = 0; i < size; i++){
            list = driver.findElements(By.cssSelector("li#app-"));
            list.get(i).click();
            int subSize = driver.findElements(By.cssSelector("[id |= doc]")).size();
            List<WebElement> subList;
            for (int j = 0; j < subSize; j++){
                subList = driver.findElements(By.cssSelector("[id |= doc]"));
                subList.get(j).click();
                isElementPresent(By.xpath("//h1"));
            }
            isElementPresent(By.xpath("//h1"));
        }
    }
}
