package ru.stqa;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

/**
 * Created by Zhanna on 26.02.2017.
 * Базовый класс в котором инициализируется и отключается драйвер.
 */
public class TestBase {
    public WebDriver driver;
    public WebDriverWait wait;

    @Before
    public void setUp(){
        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.BROWSER, Level.ALL);
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
        driver = new ChromeDriver(cap);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 5);
    }

    @After
    public void tearDown(){
        driver.quit();
        driver = null;
    }
}
