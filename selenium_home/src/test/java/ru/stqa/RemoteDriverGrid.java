package ru.stqa;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by Zhanna on 19.03.2017.
 */
public class RemoteDriverGrid {

    public WebDriver driver;
    public WebDriverWait wait;

    @Before
    public void setUp() throws Exception{
        URL hostUrl = new URL("http://192.168.56.1:4444/wd/hub");
        DesiredCapabilities caps = DesiredCapabilities.chrome();
        driver = new RemoteWebDriver(hostUrl, caps);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 5);
    }

    @After
    public void tearDown(){
        driver.quit();
        driver = null;
    }
}
