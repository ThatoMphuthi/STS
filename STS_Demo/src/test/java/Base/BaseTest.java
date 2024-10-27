package Base;

import Pages.HomePage;
import Pages.ShopPage;
import Utilities.PropertyReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    protected  static WebDriver driver;
    protected WebDriverWait wait;

    WebDriver webDriver;
    protected HomePage homePage;
    protected ShopPage shopPage;
    protected PropertyReader prop;

    @BeforeTest
    protected void Setup()
    {
        prop = new PropertyReader();
        System.out.println("Check");
        //WebDriverManager.firefoxdriver().setup();
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        webDriver = new ChromeDriver(options);
        //webDriver = new FirefoxDriver();

        webDriver.manage().window().maximize();
        webDriver.navigate().to("https://www.saucedemo.com/");
        homePage = new HomePage(webDriver);
        shopPage = new ShopPage(webDriver);
    }
    public WebElement waitForElementVisibility(WebElement element)
    {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void clickByView(String text)
    {
        //WebDriverWait wait = new WebDriverWait(webDriver,30);
    }
    public void wait(int seconds)
    {
        try {
            Thread.sleep(seconds*2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterTest
    protected void closeBrowser()
    {
        webDriver.close();
    }

}
