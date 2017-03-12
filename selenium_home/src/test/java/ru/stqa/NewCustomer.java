package ru.stqa;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import java.util.NoSuchElementException;

/**
 * Created by Zhanna on 12.03.2017.
 * Тест для задания №11
 */
public class NewCustomer extends TestBase{

    @Test
    public void loginPage() throws Exception{
        driver.get("http://localhost/litecart/en/");
        driver.findElement(By.cssSelector("a[href*='create_account']")).click();
        driver.findElement(By.cssSelector("input[name=firstname]")).sendKeys("Hannibal");
        driver.findElement(By.cssSelector("input[name=lastname]")).sendKeys("Gannibal");
        driver.findElement(By.cssSelector("input[name=address1]")).sendKeys("Hollywood");
        driver.findElement(By.cssSelector("input[name=postcode]")).sendKeys("19722");
        driver.findElement(By.cssSelector("input[name=city]")).sendKeys("Los=Angeles");
        Select select_country = new Select(driver.findElement(By.cssSelector("select[name=country_code]")));
        select_country.selectByVisibleText("United States");
        Select select_zone = new Select(driver.findElement(By.cssSelector("select[name=zone_code]")));
        select_zone.selectByVisibleText("California");
        driver.findElement(By.cssSelector("input[name=email]")).sendKeys("HannibalGannibal@yandex.ru");
        driver.findElement(By.cssSelector("input[name=phone]")).sendKeys("+1800555-55-55");
        driver.findElement(By.cssSelector("input[name=password]")).sendKeys("123");
        driver.findElement(By.cssSelector("input[name=confirmed_password]")).sendKeys("123");
        driver.findElement(By.cssSelector("button[name=create_account]")).click();
        driver.findElement(By.cssSelector("a[href*='logout']")).click();
        driver.findElement(By.cssSelector("input[name=email]")).sendKeys("HannibalGannibal@gmail.ru");
        driver.findElement(By.cssSelector("input[name=password]")).sendKeys("123");
        driver.findElement(By.cssSelector("button[name=login]")).click();
        driver.findElement(By.cssSelector("a[href*='logout']")).click();
    }
}
