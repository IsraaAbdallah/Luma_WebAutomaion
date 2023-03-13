package com.luma.pages;

import com.luma.utils.ActionHelper;
import org.openqa.selenium.By;


public class ShippingCartPage extends ActionHelper {
    By checkOutBtn = By.id("top-cart-btn-checkout");
    By qtyBox =By.xpath("/html/body");
    By update = By.xpath("//button[@id='update-cart-item-284170']");
    By itemCount = By.xpath(".//*[@id=\"minicart-content-wrapper\"]/div[2]/div[1]/span[2]");


   By totalCost = By.cssSelector("#minicart-content-wrapper > div.block-content > div.subtotal > span > span");

  public void updateQuantity(String qty){
      clearText(qtyBox);
      setText(qtyBox,qty);
      clickBtn(update);
      waitThread();

  }


  public void goToCheckout() {
      clickBtn(checkOutBtn);
      waitThread();

  }
  public Boolean validateItemCount(){
      return IsDisplayedABoolean(itemCount);
  }
    public Boolean validateTotalCost(){
        return IsDisplayedABoolean(totalCost);
    }
    public String  validateQty(){
      return getElementText(qtyBox);

    }
}
