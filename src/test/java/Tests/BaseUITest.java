package Tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public class BaseUITest {

    protected WebDriver driver;

    @Before
    public void startUp() {
        initChrome();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    private void initChrome() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
    }

    private void initFirefox() {
        FirefoxOptions options = new FirefoxOptions();
        driver = new FirefoxDriver(options);
    }
}