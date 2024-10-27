package Pages;

import Base.BaseTest;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static org.testng.Assert.*;

public class HomePage extends BaseTest {
    WebDriver webDriver;
    public  HomePage (WebDriver webDriver)
    {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }
    @FindBy(xpath = "//*[@id=\"user-name\"]")
    private WebElement usernameInput;
    @FindBy(xpath = "//*[@id=\"password\"]")
    private WebElement passwordInput;
    @FindBy(xpath = "//*[@id=\"login-button\"]")
    private WebElement loginButton;
    @FindBy(xpath = "//*[@id=\"shopping_cart_container\"]/a")
    private WebElement cart;
    @FindBy(xpath = "//*[@id=\"react-burger-menu-btn\"]")
    private WebElement menu;
    @FindBy(xpath = "//*[@id=\"logout_sidebar_link\"]")
    private WebElement logout;

    public void LoginPage()
    {
        usernameInput.sendKeys(prop.readItem("username"));
        passwordInput.sendKeys(prop.readItem("password"));
        loginButton.click();
        assertTrue(cart.isDisplayed());
    }
    public void logout()
    {
        menu.click();
        //Implicit Wait
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        logout.click();
        assertTrue(loginButton.isDisplayed());
    }
}
