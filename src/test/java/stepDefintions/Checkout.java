package stepDefintions;

import com.luma.pages.CheckoutPage;
import com.luma.pages.HomePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class Checkout {
    CheckoutPage checkoutPage= new CheckoutPage();
    HomePage homePage =new HomePage();
     @When("User enters {string} , {string} , {string} , {string} , {string} , {string} , {string} , {string} fields")
    public void user_enters_fields(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8) {
        checkoutPage.checkoutInfo(string,string2,string3,string4,string5,string6,string7,string8);

    }

    @When("User chooses state and country")
    public void user_chooses_state_and_country() {

        checkoutPage.setState(5);
    }

    @When("User chooses shipping method")
    public void user_chooses_shipping_method() {
       checkoutPage.setShippingMethod();
    }

    @When("User clicks on next button")
    public void user_clicks_on_next_button() {
        checkoutPage.goToPayment();
    }

    @Then("User is on payment page")
    public void user_is_on_payment_page() {
        String expected = homePage.verifyTitle();
        Assert.assertTrue(expected.contains("Checkout"));

    }



}
