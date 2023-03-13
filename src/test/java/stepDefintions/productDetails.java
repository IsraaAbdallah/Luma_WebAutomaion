package stepDefintions;

import com.luma.pages.HomePage;
import com.luma.pages.LoginPage;
import com.luma.pages.ProductDetailsPage;
import com.luma.pages.SearchProductPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;

public class productDetails {
    SearchProductPage searchProductPage =new SearchProductPage();
    ProductDetailsPage productDetailsPage = new ProductDetailsPage();
    LoginPage loginPage= new LoginPage();
    SoftAssert softAssert = new SoftAssert();
    String actualResult, expectedResult;
    Boolean expected;
    @When("User chooses a product")
    public void user_chooses_a_product() {
        searchProductPage.select_item();

    }

    @When("User clicks on add to cart")
    public void user_add_the_product_to_cart() {
        productDetailsPage.addItemToCart();
    }

    @Then("User can show successfully added to cart msg")
    public void user_can_show_successfully_added_to_cart_msg() {
        actualResult=productDetailsPage.validateAddToCartMsg();
        softAssert.assertTrue(actualResult.contains("You added product"));
        softAssert.assertTrue(actualResult.contains("to your shopping cart."));

    }
    @When("User clicks on add to compare")
    public void user_clicks_on_add_to_compare() {
        productDetailsPage.addItemToCompare();
    }
    @Then("User can show successfully added to compare msg")
    public void user_can_show_successfully_added_to_compare_msg() {
        actualResult = productDetailsPage.validateAddToCompareMsg();
        softAssert.assertTrue(actualResult.contains("You added product"));
        softAssert.assertTrue(actualResult.contains("to the comparison list."));
    }
    @When("User clicks on add to wishList")
    public void user_clicks_on_add_to_wish_list() {
        productDetailsPage.addItemToWish();

    }

    @Then("User is redirected to login page")
    public void user_is_redirected_to_login_page() {
        expectedResult= productDetailsPage.verifyTitle();
        softAssert.assertTrue(expectedResult.contains("login"));

    }

    @Then("A message tells the user that he must login first  or sign up is appeared")
    public void a_message_tells_the_user_that_he_must_log_in_first_or_sign_up_is_appeared() {
        expectedResult=loginPage.getErrorMsgText();
        softAssert.assertTrue(expectedResult.contains("You must login or register to add items to your wishlist."));


    }
    @When("User clicks on productDetails")
    public void user_clicks_on_product_details() {
        productDetailsPage.showProductDescription();
    }

    @Then("Product description is displayed")
    public void product_description_is_displayed() {
        expected = productDetailsPage.validateDescriptionBox();
        softAssert.assertTrue(expected);
    }
    @When("User clicks on product Info")
    public void user_clicks_on_product_info() {
        productDetailsPage.showProductInf();
    }

    @Then("Product Information is displayed")
    public void product_Information_is_displayed() {
        expected = productDetailsPage.validateMoreInfoBox();
        softAssert.assertTrue(expected);
    }



}
