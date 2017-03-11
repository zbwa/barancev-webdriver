package ru.stqa;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Zhanna on 09.03.2017.
 * Тест для задания №9.2
 */
public class GeoZones extends TestBase {
    @Test
    public void geoZones(){
        driver.get("http://localhost/litecart/admin");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        List<WebElement> categories = driver.findElements(By.cssSelector("li#app-"));
        for (int i = 0; i < categories.size(); i++){
            if(categories.get(i).getText().equals("Geo Zones")){
                categories.get(i).click();
                break;
            }
        }
        int a = driver.findElements(By.cssSelector("tr.row > td:nth-child(3) > a[href*='geo']")).size();
        for (int i = 0; i < a; i++){
            List<WebElement> countries = driver.findElements(By.cssSelector("tr.row > td:nth-child(3) > a[href*='geo']"));
            countries.get(i).click();
            List<WebElement> geoZones = driver.findElements(By.cssSelector("[selected=selected]"));
            Iterator<WebElement> iterator = geoZones.iterator();
            while(iterator.hasNext()){
                String x = iterator.next().getText();
                if(x.equals("Canada")){
                    iterator.remove();
                }
            }
            List<String> sortZones = new ArrayList<>();
            for (int j = 0; j < geoZones.size(); j++){
                sortZones.add(geoZones.get(j).getText());
            }

            for (int j = 0; j < sortZones.size(); j++){
                Assert.assertEquals(sortZones.get(j), geoZones.get(j).getText());
            }
            driver.findElement(By.name("cancel")).click();
        }
    }
}
