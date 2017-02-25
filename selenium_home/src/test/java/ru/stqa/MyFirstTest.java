package ru.stqa;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by Zhanna on 25.02.2017.
 */
public class MyFirstTest {
    WebDriver driver;
    @Test
    public void myFirstTest(){
        System.setProperty("webdriver.chrome.driver","C:\\projects\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://google.com");
        driver.close();
        driver.quit();
    }
}
