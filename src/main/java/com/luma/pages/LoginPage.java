package com.luma.pages;
import com.luma.utils.ActionHelper;
import com.luma.utils.DriverConnector;
import org.openqa.selenium.By;

public class LoginPage extends ActionHelper {
    public LoginPage(){super(); }
    By signInPage= By.linkText("Sign In");
    By email= By.id("email");
    By password= By.id("pass");
    By missingEmailErrorMessage = By.xpath("//div[@id='email-error']");
    By missingPasswordErrorMessage = By.xpath ("//div[@id='pass-error']");
    By signIn = By.cssSelector ("fieldset[class='fieldset login'] div[class='primary'] span");

    By errorMessage =By.xpath ("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']");
    By mandatoryLoginError = By.xpath("//div[@class='cf-tweet-this cf-tt-target cf-tt-element-attached-bottom cf-tt-element-attached-center cf-tt-target-attached-top cf-tt-target-attached-center']");



    public void sign_in_page(){
            clickBtn(signInPage);
        }


        public String getMissingPasswordText() {
            return getDriver().findElement(missingPasswordErrorMessage).getText();
        }
        public String getMissingEmailText() {
        return  getDriver().findElement(missingEmailErrorMessage).getText();
        }

        public Boolean getErrorMessage() {

            return getDriver().findElement(errorMessage).isDisplayed();
        }
    public String  getErrorMsgText() {

        return getDriver().findElement(errorMessage).getText();
    }

        public void login(String strUserName, String strPassword) {
            clickBtn(signInPage);
            setText(email,strUserName);
            setText(password,strPassword);
            clickBtn(signIn);
            waitThread();

    }
}
