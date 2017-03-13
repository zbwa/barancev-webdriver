package ru.stqa;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.NoSuchElementException;

/**
 * Created by Zhanna on 11.03.2017.
 * Тест для задания №10
 */
public class GoodsPage extends TestBase{
    public boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        }
        catch (NoSuchElementException e) {
            return false;
        }
    }

    public String colorRGB(String color, WebDriver driver){
        String text_color = null;
        String[] numbers = new String[3];
        if(driver instanceof FirefoxDriver) {
            numbers = color.replace("rgb(", "").replace(")", "").split(", ");
        }
        if(driver instanceof ChromeDriver){
            numbers = color.replace("rgba(", "").replace(")", "").split(", ");
        }
        int[] col = new int[3];
        int r = Integer.parseInt(numbers[0]);
        int g = Integer.parseInt(numbers[1]);
        int b = Integer.parseInt(numbers[2]);
        if (r == g && g == b){
            text_color = "GREY";
        }
        else if (g == 0 && b == 0){
            text_color = "RED";
        }

        return text_color;
    }

    public Boolean compareDimensions(String regular, String campaign){
        Float regular_num = Float.parseFloat(regular.replace("px", ""));
        Float campaign_num = Float.parseFloat(campaign.replace("px", ""));
        if(campaign_num > regular_num){
            return true;
        }
        return false;
    }

    @Test
    public void mainPage(){
        driver.get("http://localhost/litecart/en/");
        WebElement good = driver.findElement(By.xpath("//*[@id='box-campaigns']//li"));
        String name = good.findElement(By.cssSelector("div.name")).getText();
        String regular_price = good.findElement(By.cssSelector("s.regular-price")).getText();
        String color_regular = good.findElement(By.cssSelector("s.regular-price")).getCssValue("color");
        Assert.assertEquals("GREY", colorRGB(color_regular, driver));
        String line_regular = good.findElement(By.cssSelector("s.regular-price")).getCssValue("text-decoration");
        Assert.assertEquals("line-through", line_regular);
        String size_regular = good.findElement(By.cssSelector("s.regular-price")).getCssValue("font-size");
        String campaign_price = good.findElement(By.cssSelector("strong.campaign-price")).getText();
        String color_campaign = good.findElement(By.cssSelector("strong.campaign-price")).getCssValue("color");
        Assert.assertEquals("RED", colorRGB(color_campaign, driver));
        Assert.assertEquals("strong", good.findElement(By.cssSelector("strong.campaign-price")).getTagName());
        String size_campaign = good.findElement(By.cssSelector("strong.campaign-price")).getCssValue("font-size");
        Assert.assertTrue(compareDimensions(size_regular, size_campaign));
        good.click();
        isElementPresent(By.cssSelector("h1"));
        Assert.assertEquals(name, driver.findElement(By.cssSelector("h1")).getText());
        Assert.assertEquals(regular_price, driver.findElement(By.cssSelector("s.regular-price")).getText());
        Assert.assertEquals(campaign_price, driver.findElement(By.cssSelector("strong.campaign-price")).getText());
        Assert.assertEquals("GREY", colorRGB(driver.findElement(By.cssSelector("s.regular-price")).getCssValue("color"), driver));
        Assert.assertEquals("RED", colorRGB(driver.findElement(By.cssSelector("strong.campaign-price")).getCssValue("color"), driver));
        Assert.assertEquals("line-through", driver.findElement(By.cssSelector("s.regular-price")).getCssValue("text-decoration"));
        Assert.assertEquals("strong", driver.findElement(By.cssSelector("strong.campaign-price")).getTagName());
        Assert.assertTrue(compareDimensions(driver.findElement(By.cssSelector("s.regular-price")).getCssValue("font-size"), driver.findElement(By.cssSelector("strong.campaign-price")).getCssValue("font-size")));
    }
}
