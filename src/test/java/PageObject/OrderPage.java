package PageObject;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import static PageObject.MainPage.MAIN_PAGE_URL;

public class OrderPage {
    protected WebDriver driver;

    public static String ORDER_PAGE_URL = MAIN_PAGE_URL + "order";

    private final By nameInput = By.xpath(".//input[contains(@placeholder, 'Имя')]");
    private final By surnameInput = By.xpath(".//input[contains(@placeholder, 'Фамилия')]");
    private final By addressInput = By.xpath(".//div[contains(@class, 'Input_InputContainer')]/input[contains(@placeholder, 'Адрес: куда привезти заказ')]");
    private final By metroStationNameInput = By.xpath(".//input[contains(@placeholder, 'Станция метро')]");
    private final By phoneNumberInput = By.xpath(".//input[contains(@placeholder, 'Телефон: на него позвонит курьер')]");
    private final By orderNextButton = By.xpath(".//div[contains(@class, 'Order_NextButton')]/button[text()='Далее']");

    private final By deliveryDateInput = By.xpath(".//input[contains(@placeholder, 'Когда привезти самокат')]");
    private final By deliveryDateDataPicker = By.xpath(".//div[contains(@class, 'datepicker__day--selected')]");
    private final By dropdownArrowSpan = By.xpath(".//span[contains(@class, 'Dropdown-arrow')]");
    private final By openDropdown = By.xpath(".//div[contains(@class,'is-open')]");
    private final By fourDayDropdown = By.xpath(".//div[contains(@class, 'Dropdown-menu')]/div[contains(@class, 'Dropdown-option') and contains(text(), 'четверо суток')]");
    private final By threeDayDropdown = By.xpath(".//div[contains(@class, 'Dropdown-menu')]/div[contains(@class, 'Dropdown-option') and contains(text(), 'трое суток')]");
    private final By oneDayDropdown = By.xpath(".//div[contains(@class, 'Dropdown-menu')]/div[contains(@class, 'Dropdown-option') and contains(text(), 'сутки')]");
    private final By checkboxBlackInput = By.xpath(".//input[@id='black']");
    private final By checkboxGreyInput = By.xpath(".//input[@id='grey']");
    private final By orderCheckboxes = By.xpath(".//div[contains(@class, 'Order_FilledContainer')]");
    private final By messageInput = By.xpath(".//input[contains(@placeholder, 'Комментарий для курьера')]");
    private final By orderMiddleButton = By.xpath(".//div[contains(@class, 'Order_Buttons')]/button[text()='Заказать']");
    private final By orderYesButton = By.xpath(".//div[contains(@class, 'Order_Buttons')]/button[text()='Да']");

    public final By order_modal_header = By.xpath(".//div[contains(@class, 'Order_ModalHeader') and contains(text(), 'Заказ оформлен')]");

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openOrderPage() {
        driver.get(ORDER_PAGE_URL);
    }

    public void setOrderName(String name) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(nameInput));
        WebElement orderNumberWebElement = driver.findElement(nameInput);
        orderNumberWebElement.clear();
        driver.findElement(nameInput).sendKeys(name);
    }

    public void setOrderSurname(String surname) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(surnameInput));
        WebElement orderNumberWebElement = driver.findElement(surnameInput);
        orderNumberWebElement.clear();
        driver.findElement(surnameInput).sendKeys(surname);
    }

    public void setOrderAddress(String address) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(addressInput));
        WebElement orderNumberWebElement = driver.findElement(addressInput);
        orderNumberWebElement.clear();
        driver.findElement(addressInput).sendKeys(address);
    }

    public void setOrderMetroStationName(String metroStationName) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(metroStationNameInput));
        WebElement orderNumberWebElement = driver.findElement(metroStationNameInput);
        orderNumberWebElement.clear();
        driver.findElement(metroStationNameInput).sendKeys(metroStationName, Keys.ARROW_DOWN, Keys.ENTER);
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(metroStationNameInput));
    }

    public void setOrderPhoneNumber(String phoneNumber) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(phoneNumberInput));
        WebElement orderNumberWebElement = driver.findElement(phoneNumberInput);
        orderNumberWebElement.clear();
        driver.findElement(phoneNumberInput).sendKeys(phoneNumber);
    }

    public void orderNextButtonClick() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(orderNextButton));
        driver.findElement(orderNextButton).click();
    }

    public void selectDeliveryDateJS(String date) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(deliveryDateInput));
        WebElement deliveryDateElement = driver.findElement(deliveryDateInput);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = arguments[1]", deliveryDateElement, date);
    }

    public void selectDeliveryDate(String date) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(deliveryDateInput));
        driver.findElement(deliveryDateInput).sendKeys(date);
        driver.findElement(deliveryDateDataPicker).click();
    }

    public void setWrapperSpanDays(int days) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(dropdownArrowSpan));
        driver.findElement(dropdownArrowSpan).click();
        Assert.assertTrue(driver.findElement(openDropdown).isEnabled());
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(setDaysCount(days)));
        driver.findElement(setDaysCount(days)).click();
    }

    public void setCheckbox(boolean colorChange) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(colorPicker(colorChange)));
        driver.findElement(colorPicker(colorChange)).click();
        Assert.assertTrue(driver.findElement(orderCheckboxes).isEnabled());
    }

    public void setMessage(String message) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(messageInput));
        WebElement orderNumberWebElement = driver.findElement(messageInput);
        orderNumberWebElement.clear();
        driver.findElement(messageInput).sendKeys(message);
    }

    public void setOrderMiddle() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(orderMiddleButton));
        driver.findElement(orderMiddleButton).click();
    }

    public void setOrderYesButton() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(orderYesButton));
        driver.findElement(orderYesButton).click();
    }

    public void checkOrderModalHeader(String expectedText) {

        new WebDriverWait(driver, Duration.ofSeconds(7))
                .until(ExpectedConditions.visibilityOfElementLocated(order_modal_header));
        WebElement orderSuccesText = driver.findElement(order_modal_header);

        Assert.assertEquals(orderSuccesText.getText().substring(0, 14), expectedText);
    }

    public By setDaysCount(int daysCount) {
        switch (daysCount) {
            case 4:
                return fourDayDropdown;
            case 3:
                return threeDayDropdown;
            default:
                return oneDayDropdown;

        }
    }

    public By colorPicker(boolean isBlack) {
        if (isBlack) {
            return checkboxBlackInput;
        } else {
            return checkboxGreyInput;
        }
    }
}