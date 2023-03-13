package com.luma.pages;

import com.luma.utils.ActionHelper;
import org.openqa.selenium.By;

public class ProductDetailsPage extends ActionHelper {
    public  ProductDetailsPage(){super(); }

    By addToWish = By.xpath("//span[normalize-space()='Add to Wish List']");
    By addToCompare = By.cssSelector("a[class='action tocompare'] span");
    By reviews = By.id("tab-label-reviews-title");
    By addReview = By.cssSelector(".add");
    By addToCart = By.cssSelector("#product-addtocart-button > span");
    By productInfoBox = By.cssSelector("#additional");
    By productInfo = By.id("tab-label-additional-title");
    By productDescription = By.id("tab-label-description-title");
    By descriptionBox = By.cssSelector("#description > div");

    By addToCartMsg = By.xpath(("//div[@class='message-success success message']/div[contains(.,'You added Endurance Watch to your shopping cart.')]"));
    By addToCompareMsg = By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']");



    public void showProductDescription() {
        scrollToElement(productDescription);
        waitThread();
        clickBtn(productDescription);
        waitThread();
    }
    public void showProductInf() {
        scrollToElement(productInfo);
        waitThread();
        clickBtn(productInfo);
        waitThread();
    }
    public void showReviews() {
        scrollToElement(reviews);
        clickBtn(reviews);
        waitThread();
    }
    public void addItemReview() {
        clickBtn(addReview);
        waitThread();
    }
    public boolean validateDescriptionBox(){
        return IsDisplayedABoolean(descriptionBox);
    }
    public boolean validateMoreInfoBox(){
        return IsDisplayedABoolean(productInfoBox);
    }

    public void addItemToCart() {
             clickBtn(addToCart);
        waitThread();
    }

    public void addItemToCompare() {
        scrollToElement(addToCompare);

        clickBtn(addToCompare);
        waitThread();

    }
    public void addItemToWish() {
        clickBtn(addToWish);
        waitThread();

    }



    public String validateAddToCartMsg() {
        return getElementText(addToCartMsg);
    }
    public String validateAddToCompareMsg() {
        return getElementText(addToCompareMsg);
    }
    public String verifyTitle(){

        return getTitle();

    }


}


