package com.luma.pages;
import com.luma.utils.ActionHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends ActionHelper {
    public HomePage(){super(); }
    private  final By searchBox = By.id("search");
    private  final By submitSearch = By.cssSelector("button[title='Search']");
    private final By productListAutocomplete = By.cssSelector("#search_autocomplete > ul");
    private final By errorMsg =By.xpath ("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']");
    private final By shoppingCart =By.xpath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div/a");


    final By showCart = By.cssSelector(".action.showcart");



    public  void enter_productName(String productName) {
        setText(searchBox,productName);
        waiting();

    }

    public   void submit_search() {
        waitThread();

        clickBtn(submitSearch);
    }
    public List<WebElement> product_autocomplete() {
        return   getDriver().findElements(productListAutocomplete);

    }

    public  void  click_autocomplete_product(int itemIndex) {
        clickListElement(itemIndex,productListAutocomplete);
//        DriverConnector.getDriver().findElements(productListAutocomplete).get(itemIndex).click();

    }
    public String verifyTitle(){
                waitThread();
                return getTitle();

    }
    public String  getErrorMsgText() {

        return getDriver().findElement(errorMsg).getText();
    }
    public void goToCart() {
        clickBtn(showCart);
//        wait_Thread();
    }

}
