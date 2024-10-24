package Tests;

import Object.MainPage;
import Object.OrderPage;
import Object.TrackPage;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static Object.OrderPage.*;

@RunWith(Parameterized.class)
public class AdditionalScenariosTest extends BaseUITest {

    private final String errorMassage;

    public AdditionalScenariosTest(String errorMassage) {
        this.errorMassage = errorMassage;
    }

    @Parameterized.Parameters
    public static Object[] getTextData() {
        return new Object[][]{
                {NAME_ERROR_MESSAGE},
                {SURNAME_ERROR_MESSAGE},
                {ADDRESS_ERROR_MESSAGE},
                {PHONE_NUMBER_ERROR_MESSAGE},
        };
    }

    @Test
    public void checkLogoScooterClickTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.orderLogoScooterClick();
        mainPage.assertEqualsMainPageURL();
    }

    @Test
    public void checkLogoYandexClickTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.orderLogoYandexClick();
        mainPage.assertEqualsYandexPageURL();
    }

    @Test
    public void checkErrorMessageNotFilledInTest() {
        OrderPage orderPage = new OrderPage(driver);
        orderPage.openOrderPage();
        MainPage mainPage = new MainPage(driver);
        mainPage.appCookieButtonClick();
        orderPage.orderNextButtonClick();
        orderPage.assertEqualsErrorMessage(errorMassage);
        orderPage.assertEqualsErrorMessageMetro("Выберите станцию");
    }

    @Test
    public void checkErrorMessageFilledInTest() {
        OrderPage orderPage = new OrderPage(driver);
        orderPage.openOrderPage();
        MainPage mainPage = new MainPage(driver);
        mainPage.appCookieButtonClick();
        orderPage.setOrderName("Petr");
        orderPage.setOrderSurname("Petrov");
        orderPage.setOrderAddress("Lenina");
        orderPage.setOrderMetro("Pragskaya");
        orderPage.setOrderPhoneNumber("phone");
        orderPage.orderNextButtonClick();
        orderPage.assertEqualsErrorMessage(errorMassage);
        orderPage.assertEqualsErrorMessageMetro("Выберите станцию");
    }

    @Test
    public void checkOrderStatusNotExistTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.statusOrderButtonClick();
        mainPage.setOrderNumber("46987235");
        mainPage.goButtonClick();
        TrackPage trackPage = new TrackPage(driver);
        boolean isDisplayedNotFoundOrderImg = trackPage.isDisplayedNotFoundOrderImg();
        Assert.assertTrue(isDisplayedNotFoundOrderImg);
    }
}