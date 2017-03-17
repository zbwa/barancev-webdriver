package ru.stqa;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

/*Сделайте сценарий, который проверяет, что ссылки на странице редактирования страны открываются в новом окне.
Сценарий должен состоять из следующих частей:
1) зайти в админку
2) открыть пункт меню Countries (или страницу http://localhost/litecart/admin/?app=countries&doc=countries)
3) открыть на редактирование какую-нибудь страну или начать создание новой
4) возле некоторых полей есть ссылки с иконкой в виде квадратика со стрелкой -- они ведут на внешние страницы и
открываются в новом окне, именно это и нужно проверить.
Конечно, можно просто убедиться в том, что у ссылки есть атрибут target="_blank". Но в этом упражнении
требуется именно кликнуть по ссылке, чтобы она открылась в новом окне, потом переключиться в новое окно,
закрыть его, вернуться обратно, и повторить эти действия для всех таких ссылок.
Не забудьте, что новое окно открывается не мгновенно, поэтому требуется ожидание открытия окна.
*/

/**
 * Created by Zhanna on 17.03.2017.
 * Тест для задания №14
 */
public class NewWindowsLink extends TestBase{
    @Test
    public void newWindows() throws Exception{
        driver.get("http://localhost/litecart/admin");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        List<WebElement> categories = driver.findElements(By.cssSelector("#app-"));
        for(int i = 0; i < categories.size(); i++){
            if(categories.get(i).getText().equals("Countries")){
                categories.get(i).click();
                break;
            }
        }
        List<WebElement> countries = driver.findElements(By.cssSelector("tr.row > td:nth-child(5) > a[href*='country']"));
        Random random = new Random();
        countries.get(random.nextInt(238)).click();
        List<WebElement> linksCount = driver.findElements(By.cssSelector("i.fa.fa-external-link"));
        String newWin = null;
        for (int i = 0; i < linksCount.size(); i++){
            List<WebElement> links = driver.findElements(By.cssSelector("i.fa.fa-external-link"));
            String originalWin = driver.getWindowHandle();
            links.get(i).click();
            //Thread.sleep(5000);
            System.out.println(originalWin);
            Set<String> allWin = driver.getWindowHandles();
            allWin.remove(originalWin);
            Iterator<String> iterator = allWin.iterator();
            while (iterator.hasNext()){
                newWin = iterator.next();
            }
            driver.switchTo().window(newWin);
            driver.findElements(By.tagName("body"));
            driver.close();
            driver.switchTo().window(originalWin);
        }
    }
}
