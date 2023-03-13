package stepDefintions;
import com.luma.pages.HomePage;
import com.luma.pages.ProductDetailsPage;
import com.luma.pages.ReviewPage;
import com.luma.pages.SearchProductPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;

public class ReviewTest {

     SoftAssert softAssert = new SoftAssert();
     String expectedResult;
     Boolean expected;
     SearchProductPage searchProductPage =new SearchProductPage();
     ProductDetailsPage productDetailsPage = new ProductDetailsPage();
     HomePage homePage = new HomePage();
     ReviewPage reviewPage =new ReviewPage();

     @When("User clicks on reviews")
     public void user_clicks_on_reviews() {
          productDetailsPage.showReviews();
     }

     @Then("Users' reviews are displayed")
     public void users_reviews_are_displayed() {
          expected =reviewPage.validateReviewsBox();
          softAssert.assertTrue(expected);
     }
     @When("User clicks on add review")
     public void user_clicks_on_add_review() {
          productDetailsPage.addItemReview();
     }

     @When("User sets review rate")
     public void user_sets_review_rate() {
          reviewPage.setRate();
     }

     @When("User the {string} and {string} and {string} fields and clicks on submit review")
     public void user_the_and_and_and_fields_and_clicks_on_submit_review(String neckName, String summary, String review) {

          reviewPage.add_review(neckName,summary,review);

     }
     @Then("Review added successfully message is appeared")
     public void review_added_successfully_message_is_appeared() {
          expectedResult=homePage.getErrorMsgText();
          softAssert.assertTrue(expectedResult.contains("You submitted your review for moderation."));
     }

}
