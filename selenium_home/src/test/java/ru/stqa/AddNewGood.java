package ru.stqa;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by Zhanna on 13.03.2017.
 * Тест для задания №12
 */
public class AddNewGood extends TestBase {
    File file = new File("src/test/java/ru/stqa/kettlebell.jpg");
    public boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        }
        catch (NoSuchElementException e) {
            return false;
        }
    }

    @Test
    public void newGood() throws Exception{
        driver.get("http://localhost/litecart/admin");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        List<WebElement> categories = driver.findElements(By.cssSelector("li#app-"));
        for (int i = 0; i < categories.size(); i++){
            if(categories.get(i).getText().equals("Catalog")){
                categories.get(i).click();
                break;
            }
        }
        driver.findElement(By.cssSelector("a[href*='edit_product']")).click();
        WebElement enabled = driver.findElement(By.cssSelector("input[name=status][value='1']"));
        enabled.click();
        Assert.assertTrue(enabled.isSelected());
        driver.findElement(By.cssSelector("input[name='name[en]']")).sendKeys("Some Name");
        driver.findElement(By.cssSelector("input[name='code']")).sendKeys("Some Code");
        driver.findElement(By.cssSelector("input[type=checkbox][value='0']")).click();
        driver.findElement(By.cssSelector("input[type=checkbox][value='1']")).click();
        Select defaultCategory = new Select(driver.findElement(By.cssSelector("select[name=default_category_id]")));
        defaultCategory.selectByVisibleText("Rubber Ducks");
        WebElement gender = driver.findElement(By.cssSelector("input[value='1-3']"));
        gender.click();
        Assert.assertTrue(gender.isSelected());
        WebElement quantity = driver.findElement(By.cssSelector("input[name='quantity']"));
        quantity.clear();
        quantity.sendKeys("100");
        Select soldOutStatusId = new Select(driver.findElement(By.cssSelector("select[name=sold_out_status_id]")));
        soldOutStatusId.selectByVisibleText("Temporary sold out");
        //Загрузка изображения с преобразование относительного пути в абсолютный
        driver.findElement(By.cssSelector("input[name*=new_images]")).sendKeys(file.getAbsolutePath());
        driver.findElement(By.cssSelector("input[name='date_valid_from']")).sendKeys("01012015");
        driver.findElement(By.cssSelector("input[name='date_valid_to']")).sendKeys("01012020");
        //Переход на страницу Information
        driver.findElement(By.xpath("//a[contains(text(),'Information')]")).click();
        Select manufacturer_id = new Select(driver.findElement(By.cssSelector("select[name=manufacturer_id]")));
        manufacturer_id.selectByVisibleText("ACME Corp.");
        driver.findElement(By.cssSelector("input[name=keywords]")).sendKeys("Some Keywords");
        driver.findElement(By.cssSelector("input[name*=short_description]")).sendKeys("Some Description");
        driver.findElement(By.cssSelector("div.trumbowyg-editor")).sendKeys("Some Description Too");
        driver.findElement(By.cssSelector("input[name*=head_title]")).sendKeys("Some Title");
        driver.findElement(By.cssSelector("input[name*=meta_description]")).sendKeys("Some Meta Description");
        //Переход на страницу Prices
        driver.findElement(By.xpath("//a[contains(text(),'Prices')]")).click();
        WebElement purchasePrice = driver.findElement(By.cssSelector("input[name=purchase_price]"));
        purchasePrice.clear();
        purchasePrice.sendKeys("1500");
        Select priceSelect = new Select(driver.findElement(By.cssSelector("select[name=purchase_price_currency_code]")));
        priceSelect.selectByVisibleText("US Dollars");
        driver.findElement(By.cssSelector("input[name*=USD]")).sendKeys("1500");
        driver.findElement(By.cssSelector("input[name*=EUR]")).sendKeys("1407");
        driver.findElement(By.cssSelector("a#add-campaign")).click();
        WebElement startDate = driver.findElement(By.cssSelector("input[name*=start_date]"));
        startDate.sendKeys("13032000");
        startDate.sendKeys(Keys.TAB);
        startDate.sendKeys("1830");
        WebElement endDate = driver.findElement(By.cssSelector("input[name*=end_date]"));
        endDate.sendKeys("13033000");
        endDate.sendKeys(Keys.TAB);
        endDate.sendKeys("0630");
        List<WebElement> listOfUsd = driver.findElements(By.cssSelector("input[name*=USD]"));
        listOfUsd.get(listOfUsd.size()-1).sendKeys("1500");
        //Создание товара
        driver.findElement(By.cssSelector("button[name=save]")).click();
        //Проверка наличия товара
        driver.findElement(By.xpath("//a[contains(text(),'Rubber Ducks')]")).click();
        Assert.assertEquals("Some Name", driver.findElement(By.xpath("//a[contains(text(),'Some Name')]")).getText());
        isElementPresent(By.xpath("//a[contains(text(),'Some Name')]"));
    }
}
