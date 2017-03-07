package ru.stqa;

import junit.framework.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by Zhanna on 07.03.2017.
 */
public class TaskEight extends TestBase{
    @Test
    public void stickerGoodsTest(){
        driver.get("http://localhost/litecart/en/");
        int size = driver.findElements(By.cssSelector("div.middle [class=link]")).size();
        List<WebElement> list = driver.findElements(By.cssSelector("div.middle [class=link]"));
        for(int i = 0 ; i < size; i++){
            Assert.assertEquals(1, list.get(i).findElements(By.cssSelector("div > div[class*=sticker]")).size());
        }
    }
}
