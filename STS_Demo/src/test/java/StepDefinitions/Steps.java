package StepDefinitions;

import Base.BaseTest;
import org.testng.annotations.Test;

public class Steps extends BaseTest {

    @Test(priority = 1, description = "Testing")
    public void Test()
    {
        homePage.LoginPage();
        shopPage.addToCart();
        shopPage.validateCart();
        shopPage.Checkout();
        shopPage.verifyItemsAndTotalPrice();
        shopPage.finishCheckOut();
        homePage.logout();

    }
}
