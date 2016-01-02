package selenium.automation.test;


import com.applitools.eyes.Eyes;
import com.applitools.eyes.RectangleSize;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import java.net.URISyntaxException;

import org.junit.*;
//import static org.junit.Assert.*;
//import static org.hamcrest.CoreMatchers.*;
//import org.openqa.selenium.*;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class TestApplitoolsWebsite {

	@Test
	 public void validateHomePage() throws Exception, URISyntaxException, InterruptedException {

        WebDriver driver =  new ChromeDriver();

        Eyes eyes = new Eyes();
        // This is your api key, make sure you use it in all your tests.
        eyes.setApiKey("PIna1011025IwV0lMdMhoqHLoGwSEHncSPAEmfltgFpz9Fg110");

        try {
            // Start visual testing with browser viewport set to 1024x768.
            // Make sure to use the returned driver from this point on.
            driver = eyes.open(driver, "AEM", "TestHomePage", new RectangleSize(1024, 768));
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.get("http://aemauthor:4502" + "/libs/granite/core/content/login.html?resource=%2Fcontent%2Faemdemo%2Fen.html&$$login$$=%24%24login%24%24");
            driver.findElement(By.id("username")).clear();
            driver.findElement(By.id("username")).sendKeys("admin");
            driver.findElement(By.id("password")).clear();
            driver.findElement(By.id("password")).sendKeys("admin");
            driver.findElement(By.cssSelector("button.coral-Button.coral-Button--primary")).click();
            // Visual validation point #1
            eyes.checkWindow("English Page");
            driver.findElement(By.linkText("Français")).click();
            // Visual validation point #2
            eyes.checkWindow("Français page");

            // End visual testing. Validate visual correctness.
            eyes.close();
        } finally {
            // Abort test in case of an unexpected error.
            eyes.abortIfNotClosed();
            driver.quit();
        }
    }
 }
