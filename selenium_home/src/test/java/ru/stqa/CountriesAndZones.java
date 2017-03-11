package ru.stqa;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.*;

/**
 * Created by Zhanna on 08.03.2017.
 * Тест для задания №9.1
 */
public class CountriesAndZones extends TestBase{

    public boolean countryZone(By locator, String attribute){
        List<WebElement> listCountry = driver.findElements(locator);
        List<String> sortList = new ArrayList<>();
        for (int i = 0; i < listCountry.size(); i++){
            sortList.add(listCountry.get(i).getAttribute(attribute));
        }

        for (int i = 0; i < listCountry.size(); i++){
            if(!(listCountry.get(i).getAttribute(attribute).equals(sortList.get(i)))){
                System.out.println(listCountry.get(i).getAttribute(attribute) + " - " + sortList.get(i));
                return false;
            }
        }
        return true;
    }

    @Test
    public void countriesSortAlph (){
        driver.get("http://localhost/litecart/admin");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        List<WebElement> list = driver.findElements(By.cssSelector("li#app-"));
        for (int i = 0; i < list.size(); i++){
            if(list.get(i).getText().equals("Countries")){
                list.get(i).click();
                break;
            }
        }
        Assert.assertEquals("Countries", driver.findElement(By.cssSelector("h1")).getText());
        Assert.assertTrue(countryZone(By.cssSelector("tr.row > td:nth-child(5) > a[href*='country']"), "innerText"));
    }

    @Test
    public void countriesZones() throws Exception{
        driver.get("http://localhost/litecart/admin");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        List<WebElement> listLeft = driver.findElements(By.cssSelector("li#app-"));
        for (int i = 0; i < listLeft.size(); i++){
            if(listLeft.get(i).getText().equals("Countries")){
                listLeft.get(i).click();
                break;
            }
        }
        List<WebElement> list = driver.findElements(By.cssSelector("tr.row > td:nth-child(6)"));
        List<Integer> zones = new ArrayList<>();
        for (int i = 0; i < list.size(); i++){
            if (!(list.get(i).getText().equals("0"))){
                zones.add(i);
            }
        }

        for(int i = 0; i < zones.size(); i++){
            List<WebElement> listCountry = driver.findElements(By.cssSelector("tr.row > td:nth-child(5) > a[href*='country']"));
            listCountry.get(zones.get(i)).click();
            Assert.assertTrue(countryZone(By.cssSelector("table.dataTable > tbody > tr > td:nth-child(3) [type=hidden]"), "defaultValue"));
            driver.findElement(By.name("cancel")).click();
        }
    }
}
