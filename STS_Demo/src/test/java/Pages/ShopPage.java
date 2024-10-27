package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ShopPage extends BaseTest {
    WebDriver webDriver;
    public ShopPage(WebDriver webDriver)
    {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }
    @FindBy(xpath = "//*[@id=\"add-to-cart-sauce-labs-backpack\"]")
    private WebElement firstItem;
    @FindBy(xpath = "//*[@id=\"add-to-cart-sauce-labs-bike-light\"]")
    private WebElement secondItem;
    @FindBy(xpath = "//*[@id=\"login-button\"]")
    private WebElement loginButton;
    @FindBy(xpath = "//*[@id=\"shopping_cart_container\"]/a/span")
    private WebElement cart;
    @FindBy(xpath = "//*[@id=\"item_4_title_link\"]/div")
    private WebElement item1Name;
    @FindBy(xpath = "//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]/div[2]/div[2]/div")
    private WebElement item1Price;
    @FindBy(xpath = "//*[@id=\"item_0_title_link\"]/div")
    private WebElement item2Name;
    @FindBy(xpath = "//*[@id=\"cart_contents_container\"]/div/div[1]/div[4]/div[2]/div[2]/div")
    private WebElement item2Price;
    @FindBy(xpath = "//*[@id=\"checkout\"]")
    private WebElement checkoutButton;
    @FindBy(xpath = "//*[@id=\"first-name\"]")
    private WebElement firstName;
    @FindBy(xpath = "//*[@id=\"last-name\"]")
    private WebElement lastName;
    @FindBy(xpath = "//*[@id=\"postal-code\"]")
    private WebElement zip;
    @FindBy(xpath = "//*[@id=\"continue\"]")
    private WebElement continuee;
    @FindBy(xpath = "//*[@id=\"checkout_summary_container\"]/div/div[1]/div[3]/div[2]/div[2]/div")
    private WebElement item1PriceVerify;
    @FindBy(xpath = "//*[@id=\"checkout_summary_container\"]/div/div[1]/div[4]/div[2]/div[2]/div")
    private WebElement item2PriceVerify;
    @FindBy(xpath = "//*[@id=\"checkout_summary_container\"]/div/div[2]/div[8]")
    private WebElement TotalPrice;
    @FindBy(xpath = "//*[@id=\"finish\"]")
    private WebElement finish;
    @FindBy(xpath = "//*[@id=\"checkout_complete_container\"]/h2")
    private WebElement msg;
    @FindBy(xpath = "//*[@id=\"react-burger-menu-btn\"]")
    private WebElement menu;
    @FindBy(xpath = "//*[@id=\"logout_sidebar_link\"]")
    private WebElement logout;

    public void addToCart()
    {
        firstItem.click();
        secondItem.click();
        String check = cart.getText();
        assertEquals(check,prop.readItem("cartItems"));

    }
    public void validateCart()
    {
        cart.click();
        //Item 1 name and price
        String getName = item1Name.getText();
        String getPrice = item1Price.getText();
        assertEquals(getName,prop.readItem("Item1Name"));
        assertEquals(getPrice,prop.readItem("Item1Price"));
        //Item 2 name and price
        String getName2 = item2Name.getText();
        String getPrice2 = item2Price.getText();
        assertEquals(getName2,prop.readItem("Item2Name"));
        assertEquals(getPrice2,prop.readItem("Item2Price"));

    }
    public void Checkout()
    {
        checkoutButton.click();
        firstName.sendKeys(prop.readItem("firstname"));
        lastName.sendKeys(prop.readItem("lastname"));
        zip.sendKeys(prop.readItem("zip"));
        continuee.click();
    }
    public void verifyItemsAndTotalPrice()
    {
        String getName = item1Name.getText();
        String getPrice = item1PriceVerify.getText();
        assertEquals(getName,prop.readItem("Item1Name"));
        assertEquals(getPrice,prop.readItem("Item1Price"));
        //Item 2 name and price
        String getName2 = item2Name.getText();
        String getPrice2 = item2PriceVerify.getText();
        assertEquals(getName2,prop.readItem("Item2Name"));
        assertEquals(getPrice2,prop.readItem("Item2Price"));

        String item1removeCurrency = getPrice.replace("$","");
        String item2removeCurrency = getPrice2.replace("$","");

        double TOTAL = Double.parseDouble(item1removeCurrency)+Double.parseDouble(item2removeCurrency)+Double.parseDouble(prop.readItem("tax"));
        String getTotal = TotalPrice.getText();

        assertTrue(getTotal.contains(Double.toString(TOTAL)));


    }
    public  void finishCheckOut()
    {
        finish.click();
        String ThankMsg = msg.getText();
        assertEquals(ThankMsg,prop.readItem("message"));
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
