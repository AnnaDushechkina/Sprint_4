package Object;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {

    protected WebDriver driver;

    public final static String MAIN_PAGE_URL = "https://qa-scooter.praktikum-services.ru/";
    public final static String ORDER_PAGE_URL = MAIN_PAGE_URL + "order";
    public final static String YA_PAGE_URL = "https://ya.ru/";

    public void openMainPage() {
        driver.get(MAIN_PAGE_URL);
    }

    public void openOrderPage() {
        driver.get(ORDER_PAGE_URL);
    }

    void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public void assertEqualsMainPageURL() {
        Assert.assertEquals(driver.getCurrentUrl(), MAIN_PAGE_URL);
    }

    public void assertEqualsOrderPageURL() {
        Assert.assertEquals(driver.getCurrentUrl(), ORDER_PAGE_URL);
    }

    public void assertEqualsYandexPageURL() {
        Assert.assertEquals(driver.getCurrentUrl(), YA_PAGE_URL);
    }
}