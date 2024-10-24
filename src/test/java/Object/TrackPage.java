package Object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TrackPage {
    protected WebDriver driver;

    private final By notFoundImg = By.xpath(".//div[contains(@class, 'Track_NotFound')]/img");

    public TrackPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isDisplayedNotFoundOrderImg() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(notFoundImg));
        return driver.findElement(notFoundImg).isDisplayed();
    }
}