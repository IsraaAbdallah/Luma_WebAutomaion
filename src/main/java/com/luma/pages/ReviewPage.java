package com.luma.pages;

import com.luma.utils.ActionHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ReviewPage extends ActionHelper {
    public  ReviewPage(){super(); }
    By reviewsBox = By.id ("customer-reviews");

    By reviewRate= By.xpath("//label[@id='Rating_1_label']");
    By neckName = By.id("nickname_field");// clear sendKey
    By reviewSummary = By.id("summary_field");
    By reviewBody = By.id("review_field");
    By submitReview = By.cssSelector("button[class='action submit primary'] span");
    By myItemReview = By.cssSelector("#customer-reviews > div.block-content > ol > li:nth-child(1)");
    public boolean validateReviewsBox(){
        return IsDisplayedABoolean(reviewsBox);
    }

    public void setRate(){

        clickBtn(reviewRate);
        waitThread();
    }

    public void add_review(String neckName, String summary,String review)  {
        clearText(this.neckName);
        setText(this.neckName,neckName);
        setText(reviewSummary,summary);
        setText(reviewBody,review);

        clickBtn(submitReview);

        waitThread();


    }


}
