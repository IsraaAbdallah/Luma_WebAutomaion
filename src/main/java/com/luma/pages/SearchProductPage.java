package com.luma.pages;
import com.luma.utils.ActionHelper;
import com.luma.utils.DriverConnector;
import org.openqa.selenium.By;
public class SearchProductPage extends ActionHelper {
    public SearchProductPage(){super(); }

    By sortDirection = By.xpath("//body/div[@class='page-wrapper']/main[@id='maincontent']/div[@class='columns']/div[@class='column main']/div[@class='search results']/div[1]/div[1]/a[1]");
    By sorter = By.className("sorter-options");

    By relatedItems = By.xpath("/html[1]/body[1]/div[2]/main[1]/div[3]/div[1]/div[2]/dl[1]/dt[1]");
    By invalidItemMsg = By.xpath("/html/body/div[2]/main/div[3]/div[1]/div[2]/div");

    By selectItem = By.xpath("//li[8]/div[@class='product-item-info']");


      public String validate_results_page() {
        return getTitle();
    }

    public Boolean validate_related_Items() {

        return getDriver().findElement(relatedItems).isDisplayed();
    }
    public void select_item() {
        waitThread();
        clickBtn(selectItem);
        waitThread();

    }

    public Boolean validate_invalid_items_msg() {
        return getDriver().findElement(invalidItemMsg).isDisplayed();
    }

    public String validate_invalid_items_msg_text() {
        return getDriver().findElement(invalidItemMsg).getText();
    }

    public void sort_direction() {
        getDriver().findElement(sortDirection).click();
    }


    public void product_sorter() {
        getDriver().findElement(sorter).click();

    }
    public void select_product_sorter(String sorterType) {

        switch (sorterType) {
            case "name":
                getDriver().findElement(By.cssSelector("#sorter > option:nth-child(1)")).click();
                break;
            case "price":
                getDriver().findElement(By.cssSelector("#sorter > option:nth-child(2)")).click();
                break;
            case "relevance":
                getDriver().findElement(By.cssSelector("#sorter > option:nth-child(3)")).click();

        }

    }






}
