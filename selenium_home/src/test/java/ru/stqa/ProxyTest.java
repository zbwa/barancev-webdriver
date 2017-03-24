package ru.stqa;

import net.lightbody.bmp.core.har.Har;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

/**
 * Created by Zhanna on 24.03.2017.
 * Тест для задания №17
 */
public class ProxyTest extends TestBase{
    @Test
    public void myFirstTest0() throws Exception{
        proxy.newHar();
        driver.get("https://www.sports.ru/");
        /*driver.findElement(By.cssSelector("input.search-block__input")).sendKeys("Александр Кержаков");
        driver.findElement(By.cssSelector("input.search-block__input")).sendKeys(Keys.ENTER);
        driver.findElement(By.cssSelector("a[title='Александр Кержаков']")).click();*/
        Har har = proxy.endHar();
        har.getLog().getEntries().forEach(l -> System.out.println(l.getResponse().getStatus() + ":" + l.getRequest().getUrl()));
    }
}
