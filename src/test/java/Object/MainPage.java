package Object;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage extends BasePage {

    private static final String FAQ_QUESTION_PATTERN = ".//div[contains(@id, 'accordion__heading') and contains(text(), '%s')]";
    private static final String FAQ_QUESTION_TEXT = ".//div[contains(@id, 'accordion__panel')]/p[contains(text(), '%s')]";

    public static final String HOW_MUCH_COSTS_QUESTION = "Сколько это стоит? И как оплатить?";
    public static final String HOW_MUCH_COSTS_QUESTION_TEXT = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    public static final String SEVERAL_SCOOTERS_QUESTION = "Хочу сразу несколько самокатов! Так можно?";
    public static final String SEVERAL_SCOOTERS_QUESTION_TEXT = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    public static final String RENTAL_TIME_QUESTION = "Как рассчитывается время аренды?";
    public static final String RENTAL_TIME_QUESTION_TEXT = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    public static final String ORDER_FOR_TODAY_QUESTION = "Можно ли заказать самокат прямо на сегодня?";
    public static final String ORDER_FOR_TODAY_QUESTION_TEXT = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    public static final String EXTEND_RETURN_EARLIER_QUESTION = "Можно ли продлить заказ или вернуть самокат раньше?";
    public static final String EXTEND_RETURN_EARLIER_QUESTION_TEXT = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    public static final String BRING_CHARGER_ALONG_QUESTION = "Вы привозите зарядку вместе с самокатом?";
    public static final String BRING_CHARGER_ALONG_QUESTION_TEXT = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    public static final String CANCEL_ORDER_QUESTION = "Можно ли отменить заказ?";
    public static final String CANCEL_ORDER_QUESTION_TEXT = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    public static final String LIVE_FAR_AWAY_QUESTION = "Я живу за МКАДом, привезёте?";
    public static final String LIVE_FAR_AWAY_QUESTION_TEXT = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";

    private final By orderHeaderButton = By.xpath(".//div[contains(@class, 'Header_Nav')]/button[text()='Заказать']");
    private final By orderDownButton = By.xpath(".//div[contains(@class, 'Home_FinishButton')]/button[text()='Заказать']");
    private final By appCookieButton = By.xpath(".//button[@id='rcc-confirm-button']");
    private final By imgLogoScooter = By.xpath(".//img[@alt='Scooter']");
    private final By imgLogoYandex = By.xpath(".//img[@alt='Yandex']");
    private final By statusOrderButton = By.xpath(".//button[contains(@class, 'Header_Link')]");
    private final By orderNumberInput = By.xpath(".//input[@type = 'text']");
    private final By goButton = By.xpath(".//button[contains(@class, 'Header_Button') and text()='Go!']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void appCookieButtonClick() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(appCookieButton));
        driver.findElement(appCookieButton).click();
    }

    public void orderLogoScooterClick() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(imgLogoYandex));
        driver.findElement(imgLogoYandex).click();
    }

    public void orderLogoYandexClick() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(imgLogoScooter));
        driver.findElement(imgLogoScooter).click();
    }

    public void statusOrderButtonClick() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(statusOrderButton));
        driver.findElement(statusOrderButton).click();
    }

    public void setOrderNumber(String orderNumberValue) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(orderNumberInput));
        WebElement orderNumberWebElement = driver.findElement(orderNumberInput);
        orderNumberWebElement.clear();
        driver.findElement(orderNumberInput).sendKeys(orderNumberValue);
    }

    public void goButtonClick() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(goButton));
        driver.findElement(goButton).click();
    }

    public void orderButtonHeaderClick() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(orderHeaderButton));
        driver.findElement(orderHeaderButton).click();
    }

    public void orderButtonDownClick(String questionMessage) {
        String questionLocator = String.format(FAQ_QUESTION_PATTERN, questionMessage);
        WebElement questionElement = driver.findElement(By.xpath(questionLocator));
        scrollToElement(questionElement);
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(questionLocator)));
        driver.findElement(orderDownButton).click();
    }

    public void clickFAQQuestion(String questionMessage, String questionText) {

        String questionLocator = String.format(FAQ_QUESTION_PATTERN, questionMessage);
        WebElement questionElement = driver.findElement(By.xpath(questionLocator));
        scrollToElement(questionElement);
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(questionLocator)));
        questionElement.click();

        String questionLocatorText = String.format(FAQ_QUESTION_TEXT, questionText);
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(questionLocatorText)));
        WebElement questionElementText = driver.findElement(By.xpath(questionLocatorText));

        Assert.assertEquals(questionElementText.getText().toString(), questionText);
    }
}