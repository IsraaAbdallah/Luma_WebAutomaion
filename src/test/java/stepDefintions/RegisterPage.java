package stepDefintions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;
import java.util.Arrays;

public class RegisterPage {

    com.luma.pages.RegisterPage objRegister =new com.luma.pages.RegisterPage();
    SoftAssert softAssert = new SoftAssert();
   String actualResult, expectedResult;

    @Given("User navigates to Create an Account page")
    public void user_navigates_to_create_an_account_page() {

        objRegister.create_an_account_page();
    }

    @When("User fills the {string} and {string} and {string} and {string} and {string} and clicks on Create an Account button")
    public void user_fills_the_and_and_and_and_and_clicks_on_create_an_account_button(String fName, String lName,
       String email, String password, String confirmPassword) {
        objRegister.createAnAccount(fName,lName,email,password,confirmPassword);

    }

    @Then("User account should be created successfully")
    public void user_account_should_be_created_successfully() {
        softAssert.assertTrue(objRegister.successfulRegisterMsgDisplayed());


    }

    @Then("Welcome user message is displayed")
    public void welcome_user_message_is_displayed() {
        String welcome_user= objRegister.welcome_user();
    }



    @When("A warning about a duplicate account using a duplicate email should be appeared")
    public void a_warning_about_a_duplicate_account_using_a_duplicate_email_should_be_appeared() {
      softAssert.assertTrue(objRegister.IsDuplicateAccountMsgDisplayed());

    }

    @When("A link to reset forget password page is displayed")
    public void a_link_to_reset_forget_password_page_is_displayed() {
        softAssert.assertTrue(objRegister.IsForgetPasswordDisplayed());


    }

    @When("User clicks on reset password link")
    public void user_clicks_on_reset_password_link() {
        objRegister.validateForgetPasswordLink();
    }

    @Then("User is on forget password page")
    public void user_is_on_forget_password_page() {
       actualResult= objRegister.validateForgetPasswordPage();
       expectedResult= "Forgot Your Password? Magento Commerce - website to practice selenium | demo website for automation testing | selenium practice sites";
       softAssert.assertEquals(actualResult,expectedResult,"Title is not matching");

    }

    @Then("A warning of missing field is displayed for each mandatory field")
    public void a_warning_of_missing_field_is_displayed_for_each_mandatory_field() {
        expectedResult = "This is a required field.";
        String[] actualMissingFieldMsg = {objRegister.getMissingFirstNameText(), objRegister.getMissingLastNameText(),
                objRegister.getMissingEmailText(), objRegister.getMissingPasswordText(), objRegister.getMissingPasswordConfirmationText()};

        for (String fieldMsg : actualMissingFieldMsg) {
            softAssert.assertEquals(fieldMsg , expectedResult, "Missing item" + Arrays.asList(actualMissingFieldMsg).indexOf(fieldMsg) + " test is failed");

        }
    }

}
