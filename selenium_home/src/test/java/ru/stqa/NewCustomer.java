package ru.stqa;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import java.util.NoSuchElementException;

/**
 * Created by Zhanna on 12.03.2017.
 */
public class NewCustomer extends TestBase{
    public boolean isElementPresent(By locator){
        try {
            driver.findElement(locator);
            return true;
        }
        catch (NoSuchElementException e){
            return false;
        }
    }
    @Test
    public void loginPage(){
        driver.get("http://localhost/litecart/en/");
        driver.findElement(By.cssSelector("a[href*='create_account']")).click();
        isElementPresent(By.cssSelector("h1"));
        System.out.println(driver.findElement(By.cssSelector("h1")).getText());
        Assert.assertEquals("Create Account", driver.findElement(By.cssSelector("h1")).getText());
    }
}
