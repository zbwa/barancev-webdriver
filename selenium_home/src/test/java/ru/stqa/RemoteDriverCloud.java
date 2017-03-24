package ru.stqa;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;

/**
 * Created by Zhanna on 20.03.2017.
 */
public class RemoteDriverCloud {

    public WebDriver driver;
    public WebDriverWait wait;
    public static final String USERNAME = "zverevdmitri1";
    public static final String AUTOMATE_KEY = "EV4pBUiyk43z8zx4wdH4";
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    @Before
    public void setUp() throws Exception{
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browser", "chrome");
        caps.setCapability("browserstack.debug", "true");
        caps.setCapability("build", "First build");
        driver = new RemoteWebDriver(new URL(URL), caps);
        wait = new WebDriverWait(driver, 5);
    }
    @After
    public void tearDown(){
        driver.quit();
        driver = null;
    }
}
