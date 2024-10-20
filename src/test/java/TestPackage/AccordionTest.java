package TestPackage;

import PageObject.MainPage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static PageObject.MainPage.*;

@RunWith(Parameterized.class)
public class AccordionTest extends BaseUITest {

    private final String question;
    private final String questionText;

    public AccordionTest(String question, String questionText) {
        this.question = question;
        this.questionText = questionText;
    }

    @Parameterized.Parameters
    public static Object[][] getQuestionData() {
        return new Object[][]{
                {HOW_MUCH_COSTS_QUESTION, HOW_MUCH_COSTS_QUESTION_TEXT},
                {SEVERAL_SCOOTERS_QUESTION, SEVERAL_SCOOTERS_QUESTION_TEXT},
                {RENTAL_TIME_QUESTION, RENTAL_TIME_QUESTION_TEXT},
                {ORDER_FOR_TODAY_QUESTION, ORDER_FOR_TODAY_QUESTION_TEXT},
                {EXTEND_RETURN_EARLIER_QUESTION, EXTEND_RETURN_EARLIER_QUESTION_TEXT},
                {BRING_CHARGER_ALONG_QUESTION, BRING_CHARGER_ALONG_QUESTION_TEXT},
                {CANCEL_ORDER_QUESTION, CANCEL_ORDER_QUESTION_TEXT},
                {LIVE_FAR_AWAY_QUESTION, LIVE_FAR_AWAY_QUESTION_TEXT},
        };
    }

    @Test
    public void dataPickerTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.appCookieButtonClick();
        mainPage.clickFAQQuestion(question, questionText);
    }
}