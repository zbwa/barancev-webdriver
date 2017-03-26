package ru.stqa;

import net.lightbody.bmp.core.har.Har;
import org.junit.Test;

import java.io.File;

/**
 * Created by Zhanna on 24.03.2017.
 * Тест для задания №17
 */
public class ProxyTest extends TestBase{
    @Test
    public void myFirstTest0() throws Exception{
        File file = new File("C:\\web_drivers\\test.txt");
        proxy.newHar();
        driver.get("http://google.com");
        Har har = proxy.endHar();
        har.writeTo(file);
        har.getLog().getEntries().forEach(l -> System.out.println(l.getResponse().getStatus()));
    }
}
