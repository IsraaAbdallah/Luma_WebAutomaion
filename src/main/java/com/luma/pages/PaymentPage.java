package com.luma.pages;

import com.luma.utils.ActionHelper;
import org.openqa.selenium.By;

public class PaymentPage extends ActionHelper {
    By placeOrder = By.cssSelector(".checkout > span");
    By continueShopping =By.xpath("//a[@class='action primary continue']");
    public void orderProduct(){
        waitThread();
        clickBtn(placeOrder);
        waitThread();
    }

    public  void setContinue_shopping(){
        clickBtn(continueShopping);
    }
}
