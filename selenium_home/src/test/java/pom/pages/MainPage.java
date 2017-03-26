package pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Zhanna on 26.03.2017.
 * Описание главной страницы приложения Litecart
 */
public class MainPage extends Page{

    public MainPage(WebDriver driver){
        super(driver);
    }

    public void mainPageOpen(){
        driver.get("http://localhost/litecart/en/");
    }

    public void goodPageOpen(){
        driver.findElement(By.cssSelector("div.middle [class=link]")).click();
    }

    public void openCheckout(){
        driver.findElement(By.cssSelector("a.link")).click();
    }
}
