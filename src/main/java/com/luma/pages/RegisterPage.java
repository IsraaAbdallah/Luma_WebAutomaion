package com.luma.pages;
import com.luma.utils.ActionHelper;
import org.openqa.selenium.By;


public class RegisterPage extends ActionHelper {
    public RegisterPage(){super(); }



    By  createAccount = By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[3]/a");
    By firstName = By.cssSelector("#firstname");
    By lastName = By.cssSelector("#lastname");
    By emailAddress = By.cssSelector("#email_address");
    By password = By.cssSelector("#password");
    By passwordConfirmation = By.cssSelector("#password-confirmation");
    By createAccountBtn = By.cssSelector(".submit > span");
     By successfulRegisterMsg =By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']" );

    By welcomeUser = By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[1]/span");

    By missingFirstName = By.id("firstname-error");
    By  missingLastName = By.id("lastname-error");
    By  missingEmail = By.id("email_address-error");
    By  missingPassword = By.id("password-error");
    By missingPasswordConfirmation = By.id ( "password-confirmation-error" );
    By resetPasswordLink = By.xpath ( "//a[normalize-space()='click here']" );
    By duplicateAccountError= By.xpath ( "//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']" );



    public void create_an_account_page(){
        clickBtn(createAccount);
        waiting();

    }
    public String getMissingFirstNameText() {
        return  getDriver().findElement(missingFirstName).getText();
    }
    public String getMissingLastNameText() {
        return  getDriver().findElement(missingLastName).getText();
    }
    public String getMissingEmailText() {
        return  getDriver().findElement(missingEmail).getText();
    }
    public String getMissingPasswordText() {
        return  getDriver().findElement(missingPassword).getText();
    }
    public String getMissingPasswordConfirmationText() {
        return  getDriver().findElement(missingPasswordConfirmation).getText();
    }


    public void createAnAccount(String strFirstName, String strLastName,String strEmail,
                                String strPassword,String strPasswordConfirmation)  {
        setText(firstName,strFirstName);
        setText(lastName,strLastName);
        setText(emailAddress,strEmail);
        setText(password,strPassword);
        setText(passwordConfirmation,strPasswordConfirmation);
        scrollToElement(createAccountBtn);
        clickBtn(createAccountBtn);

        waitThread();


    }

    public  Boolean successfulRegisterMsgDisplayed(){
        return   getDriver().findElement(successfulRegisterMsg).isDisplayed();
    }
    public String welcome_user(){
       return  getDriver().findElement(welcomeUser).getText();
    }
    public void validateForgetPasswordLink(){
        clickBtn(resetPasswordLink);


    }
    public Boolean IsForgetPasswordDisplayed(){
        return getDriver().findElement(resetPasswordLink).isDisplayed();

    }
    public Boolean IsDuplicateAccountMsgDisplayed(){
        return  getDriver().findElement(duplicateAccountError).isDisplayed();
    }
    public String validateForgetPasswordPage(){
       return getTitle();
    }

}
