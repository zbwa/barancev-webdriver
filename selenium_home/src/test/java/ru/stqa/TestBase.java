package ru.stqa;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by Zhanna on 26.02.2017.
 * Базовый класс в котором инициализируется и отключается драйвер.
 */
public class TestBase {
    public WebDriver driver;
    public WebDriverWait wait;

    @Before
    public void setUp(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 5);
    }

    @After
    public void tearDown(){
        driver.quit();
        driver = null;
    }
}
