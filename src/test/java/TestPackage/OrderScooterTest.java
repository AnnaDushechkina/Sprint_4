package TestPackage;

import PageObject.MainPage;
import PageObject.OrderPage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.time.LocalDate;
import static PageObject.MainPage.*;

@RunWith(Parameterized.class)
public class OrderScooterTest extends BaseUITest {
    private final String name;
    private final String surname;
    private final String address;
    private final String metroStationName;
    private final String phoneNumber;
    private final LocalDate deliveryDate;
    private final int daysCount;
    private final boolean isBlack;
    private final String comment;

    public OrderScooterTest(String name, String surname, String address,
                            String metroStationName, String phoneNumber, LocalDate deliveryDate, int daysCount, boolean color, String comment) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metroStationName = metroStationName;
        this.phoneNumber = phoneNumber;
        this.deliveryDate = deliveryDate;

        this.daysCount = daysCount;
        this.isBlack = color;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] getTextData() {
        return new Object[][]{
                {"Петр", "Петров", "Ленина, 1", "Рижская", "89129126612", LocalDate.now().plusDays(1), 3, true, ""},
                {"Иван", "Иванов", "Ленина, 2", "Рижская", "+79129126612", LocalDate.now().plusDays(2), 4, false, "не звонить"},
        };
    }

    @Test
    public void checkNameInputTest() {
        OrderPage orderPage = new OrderPage(driver);
        orderPage.openOrderPage();
        MainPage mainPage = new MainPage(driver);
        mainPage.appCookieButtonClick();
        orderPage.setOrderName(name);
        orderPage.setOrderSurname(surname);
        orderPage.setOrderAddress(address);
        orderPage.setOrderMetroStationName(metroStationName);
        orderPage.setOrderPhoneNumber(phoneNumber);
        orderPage.orderNextButtonClick();

        orderPage.selectDeliveryDateJS(deliveryDate.toString());
        orderPage.selectDeliveryDate(deliveryDate.toString());
        orderPage.setWrapperSpanDays(daysCount);
        orderPage.setCheckbox(isBlack);
        orderPage.setMessage(comment);
        orderPage.setOrderMiddle();

        orderPage.setOrderYesButton();
        orderPage.checkOrderModalHeader("Заказ оформлен");
    }

    @Test
    public void checkOrderHeaderClickTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.appCookieButtonClick();
        mainPage.orderButtonHeaderClick();
    }

    @Test
    public void checkOrderButtonDownTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.appCookieButtonClick();
        mainPage.orderButtonDownClick(HOW_MUCH_COSTS_QUESTION);
    }
}