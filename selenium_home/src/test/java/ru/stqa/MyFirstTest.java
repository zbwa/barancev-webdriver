package ru.stqa;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

/**
 * Created by Zhanna on 25.02.2017.
 * Тест для задания №1
 */
public class MyFirstTest extends RemoteDriverGrid{
    @Test
    public void myFirstTest0() throws Exception{
        driver.get("https://www.sports.ru/");
        Thread.sleep(5000);
        driver.findElement(By.cssSelector("input.search-block__input")).sendKeys("Александр Кержаков");
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("input.search-block__input")).sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("a[title='Александр Кержаков']")).click();
    }

    @Test
    public void myFirstTest1(){
        driver.get("https://google.com");
    }

    @Test
    public void myFirstTest2(){
        driver.get("https://google.com");
    }

    @Test
    public void myFirstTest3(){
        driver.get("https://google.com");
    }

    @Test
    public void myFirstTest4(){
        driver.get("https://google.com");
    }

    @Test
    public void myFirstTest5(){
        driver.get("https://google.com");
    }

    @Test
    public void myFirstTest6(){
        driver.get("https://google.com");
    }
}
