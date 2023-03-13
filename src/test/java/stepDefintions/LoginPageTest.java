package stepDefintions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class LoginPageTest {
    com.luma.pages.LoginPage objLogin = new com.luma.pages.LoginPage();

    @Given("User is on login page")
    public void the_user_is_on_login_page(){

        objLogin.sign_in_page();


    }

    @When("User fills email field as {string} and password field as {string} and hits submit button")
    public void user_fill_email_as_and_password_as(String userName, String password) {

        objLogin.login(userName, password);

    }
    @Then("User should be logged in successfully")
    public void the_user_should_be_logged_in_successfully() {
        System.out.println("the user should be logged in successfully");
    }
    @Then("Error message should appear")
    public void error_message_should_appear() {
        Boolean expectedError= true;
        Boolean actualErrorMessage = objLogin.getErrorMessage();
        Assert.assertEquals(actualErrorMessage,expectedError);
    }
    @Then("missing email message and missing password messages should appear")
    public void missing_email_password_messages_should_appear(){
        String emailMessage= objLogin.getMissingEmailText();
        String passwordMessage= objLogin.getMissingPasswordText();
        Assert.assertEquals(emailMessage,"This is a required field.");
        Assert.assertEquals(passwordMessage,"This is a required field.");

    }

}
