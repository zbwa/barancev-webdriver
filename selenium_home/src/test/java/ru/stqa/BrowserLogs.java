package ru.stqa;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.Logs;

import java.util.List;

/**
 * Created by Zhanna on 22.03.2017.
 * Тест для задания №17
 */
public class BrowserLogs extends TestBase {
    @Test
    public void logging() throws Exception{
        driver.get("http://localhost/litecart/admin");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        for (LogEntry l : driver.manage().logs().get("browser").getAll()) {
            System.out.println(l);
        }
        List<WebElement> listVertical = driver.findElements(By.cssSelector("li#app-"));
        for (int i = 0; i < listVertical.size(); i++){
            if(listVertical.get(i).getText().equals("Catalog")){
                listVertical.get(i).click();
                for (LogEntry l : driver.manage().logs().get("browser").getAll()) {
                    System.out.println(l);
                }
                break;
            }
        }
        driver.findElement(By.cssSelector("td > a")).click();
        for (LogEntry l : driver.manage().logs().get("browser").getAll()) {
            System.out.println(l);
        }
        List<WebElement> goodsList = driver.findElements(By.xpath("//a[contains(text(),'Duck')]"));
        for (int i= 1; i < goodsList.size(); i++){
            List<WebElement> goodsList1 = driver.findElements(By.xpath("//a[contains(text(),'Duck')]"));
            goodsList1.get(i).click();
            driver.findElement(By.cssSelector("button[name='cancel']")).click();
            for (LogEntry l : driver.manage().logs().get("browser").getAll()) {
                System.out.println(l);
            }
        }
    }
}
