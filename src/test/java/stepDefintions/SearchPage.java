package stepDefintions;
import com.luma.pages.HomePage;
import com.luma.pages.SearchProductPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;

public class SearchPage {
    HomePage homePage= new HomePage();

    SearchProductPage objSearch= new SearchProductPage();
    SoftAssert softAssert = new SoftAssert();
    @Given("User opens the application")
    public void user_opens_the_application() {
       String title= homePage.verifyTitle();
       softAssert.assertTrue(title.contains("https://magento.softwaretestingboard.com/"));
    }

    @When("User enters a {string} into search box field")
    public void user_enters_a_valid_product_name_into_search_box_field(String productName) {
        //String productName = "Digital watch";
        homePage.enter_productName(productName);

    }

    @When("User submits search")
    public void user_press_enter_key_from_keyboard() {

        homePage.submit_search();
    }

    @Then("User should get valid product displayed in search results")
    public void user_should_get_valid_product_displayed_in_search_results() {
        String result = objSearch.validate_results_page();
        softAssert.assertTrue(result.contains("Digital watch"));
    }

    @Then("Related search terms list is displayed")
    public void related_search_terms_list_is_displayed() {

        Boolean result = objSearch.validate_related_Items();
        softAssert.assertTrue(result);
    }


    @When("User clicks on sort direction arrow")
    public void user_clicks_on_sort_direction_arrow() {
        objSearch.sort_direction();

    }
    @Then("Sort Direction should be changed")
    public void sort_direction_should_be_changed() {
        softAssert.assertTrue(homePage.verifyTitle().contains("product_list_dir="));


    }



    @Then("User should get a warning message about returning no results")
    public void user_should_get_a_warning_message_about_returning_no_results() {
        softAssert.assertTrue(objSearch.validate_invalid_items_msg());
        softAssert.assertEquals(objSearch.validate_invalid_items_msg_text(),"Your search returned no results.");

    }

    @Then("Relevant keywords are suggested in the autocomplete search list")
    public void relevant_keywords_are_suggested_in_the_autocomplete_search_list() {
        softAssert.assertTrue(homePage.product_autocomplete().toString().contains("search_autocomplete"));

    }
    @When("User clicks on an item in the list")
    public void user_clicks_on_an_item_in_the_list() {
        homePage.click_autocomplete_product(0 );


    }


    @When("User selects a sorter from a sorter list")
    public void user_selects_a_sorter_from_sorter_list() {
       objSearch.product_sorter();

    }
    @Then("Products should be ordered by the selected sorter")
    public void products_should_be_ordered_by_the_selected_sorter() {
        objSearch.select_product_sorter("price");
        String title= homePage.verifyTitle();
        softAssert.assertTrue(title.contains("product_list_order="));


    }

}
