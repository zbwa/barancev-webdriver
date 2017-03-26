package pom.App;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pom.pages.CheckoutPage;
import pom.pages.GoodPage;
import pom.pages.MainPage;

/**
 * Created by Zhanna on 26.03.2017.
 */
public class Application {

    private WebDriver driver;

    private MainPage mainPage;
    private GoodPage goodPage;
    private CheckoutPage checkoutPage;

    public Application(){
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        goodPage = new GoodPage(driver);
        checkoutPage = new CheckoutPage(driver);
    }

    public void quit(){
        driver.quit();
    }

    public void open(){
        mainPage.mainPageOpen();
    }

    public void addGood(){
        mainPage.goodPageOpen();
        goodPage.addGoodToCart();
    }

    public void checkout(){
        mainPage.openCheckout();
    }

    public void deleteFew(){
        checkoutPage.deleteFew();
    }

    public void deleteOne(){
        checkoutPage.deleteOne();
    }
}
