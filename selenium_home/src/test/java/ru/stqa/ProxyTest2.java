package ru.stqa;

import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.core.har.Har;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class ProxyTest2 {
    private WebDriver driver;
    private WebDriverWait wait;
    private BrowserMobProxy proxy;

    @Before
    public void start() {
        proxy = new BrowserMobProxyServer();
        proxy.start(8888);
        Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxy);

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(CapabilityType.PROXY, seleniumProxy);

        this.driver = new ChromeDriver(caps);
        this.driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void myFirstTest() {
        File file = new File("C:\\web_drivers\\test.txt");
        proxy.newHar();

        driver.get("https://www.google.com/ncr");
        driver.findElement(By.name("q")).sendKeys("webdriver");
        driver.findElement(By.name("btnG")).click();
        wait.until(titleIs("webdriver - Google Search"));

        Har har = proxy.endHar();
        // Write to file
        try {
            har.writeTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Write to console Status : URL
        har.getLog().getEntries().forEach(entry -> System.out.println(entry.getResponse().getStatus() + " : " + entry.getRequest().getUrl()));
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }

}