package com.luma.pages;

import com.luma.utils.ActionHelper;
import org.openqa.selenium.By;

public class CheckoutPage extends ActionHelper {
    By shippingMethod = By.cssSelector(".row:nth-child(1) .radio");
    By customerEmail = By.xpath("//fieldset[@id='customer-email-fieldset']/div/div/input");

    By firstNameBox =By.xpath("//div[@id='shipping-new-address-form']/div/div/input");
    By lastNameBox =By.xpath("//div[@id='shipping-new-address-form']/div[2]/div/input");
    By companyBox =By.xpath("//div[@id='shipping-new-address-form']/div[3]/div/input");
    By streetBox =By.xpath("//div[@id='shipping-new-address-form']/fieldset/div/div/div/input");
    By cityBox =By.xpath("//div[@id='shipping-new-address-form']/div[4]/div/input");
    By phoneBox =By.xpath("//div[@id='shipping-new-address-form']/div[9]/div/input");
    By zipcodeBox =By.xpath("//div[@id='shipping-new-address-form']/div[7]/div/input");
    By state =By.xpath("/html[1]/body[1]/div[1]/main[1]/div[2]/div[1]/div[2]/div[4]/ol[1]/li[1]/div[2]/form[2]/div[1]/div[5]/div[1]/select[1]");
    By nextBtn = By.cssSelector(".button");
    public  void checkoutInfo(String email,String first, String last, String company,String street
            , String city, String phone, String code){
        setText(customerEmail,email);
        setText(firstNameBox,first);
        setText(lastNameBox,last);
        setText( companyBox,company);
        setText(streetBox,street);
        setText(cityBox,city);
        setText(phoneBox,phone);
        setText(zipcodeBox,code);


    }
    public void setState(int index){
       selectElementIndex(state,index);
    }

    public void setShippingMethod(){
        clickBtn(shippingMethod);
        waitThread();
    }
    public void goToPayment(){
        clickBtn(nextBtn);
    }


}
