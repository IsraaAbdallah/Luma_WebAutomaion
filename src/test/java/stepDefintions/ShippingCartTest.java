package stepDefintions;

import com.luma.pages.HomePage;
import com.luma.pages.ShippingCartPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class ShippingCartTest {
    HomePage homePage = new HomePage();
    ShippingCartPage shippingCartPage = new ShippingCartPage();
    Boolean expectedResult;
    String expected;
    String quantity="2";
    @When("User clicks on go to cart")
    public void user_clicks_on_go_to_cart() {
        homePage.goToCart();
    }

    @Then("Total price is displayed")
    public void total_price_is_displayed() {
        expectedResult = shippingCartPage.validateTotalCost();
        Assert.assertTrue(expectedResult);

    }
    @Then("Count of products is displayed")
    public void count_of_products_is_displayed() {
        expectedResult = shippingCartPage.validateItemCount();
        Assert.assertTrue(expectedResult);
    }


    @When("User chane product quantity and clicks update")
    public void user_chane_product_quantity_and_clicks_update() {

        shippingCartPage.updateQuantity(quantity);

    }
    @When("Product quantity should be updated")
    public void product_quantity_should_be_updated() {
        expected = shippingCartPage.validateQty();
        Assert.assertEquals(expected,quantity);

    }
    @When("User clicks on checkout button")
    public void user_clicks_on_checkout_button() {
        shippingCartPage.goToCheckout();
    }
    @When("User is on checkout page")
    public void user_is_on_checkout_page() {
        expected = homePage.verifyTitle();
    }


}
