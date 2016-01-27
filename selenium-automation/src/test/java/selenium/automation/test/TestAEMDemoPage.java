package selenium.automation.test;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestAEMDemoPage {
  private WebDriver driver;
  private String baseUrl;
  //private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    //driver = new FirefoxDriver();
	driver = new ChromeDriver();
    baseUrl = "http://localhost:4502";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void validateHomePage() throws Exception {
    driver.get(baseUrl + "/libs/granite/core/content/login.html?resource=%2Fcontent%2Faemdemo%2Fen.html&$$login$$=%24%24login%24%24");
    //maximize didn't work 
    //driver.manage().window().maximize();
    driver.findElement(By.id("username")).clear();
    driver.findElement(By.id("username")).sendKeys("admin");
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("admin");
    //driver.findElement(By.id("submit-button")).click();
    
    WebElement element = driver.findElement(By.id("submit-button"));
    Actions action = new Actions(driver);
    action.moveToElement(element).click().perform();
    
    driver.get(baseUrl + "/content/aemdemo/fr.html");
    //driver.findElement(By.linkText("Français")).click();
    driver.findElement(By.linkText("English")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }
}
