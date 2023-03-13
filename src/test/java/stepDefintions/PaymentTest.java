package stepDefintions;

import com.luma.pages.HomePage;
import com.luma.pages.PaymentPage;
import io.cucumber.java.en.Then;

public class PaymentTest {
    HomePage homePage= new HomePage();
    PaymentPage paymentPage= new PaymentPage();

    @Then("User clicks on place order")
    public void user_clicks_on_place_order() {
        paymentPage.orderProduct();
    }
    @Then("User clicks on continue shopping")
    public void user_clicks_on_continue_shopping() {
        paymentPage.setContinue_shopping();

    }
    @Then("User is on home page")
    public void user_is_on_home_page() {
        homePage.verifyTitle();
    }

}
