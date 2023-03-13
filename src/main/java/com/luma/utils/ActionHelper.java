package com.luma.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class ActionHelper {

    protected final int TIMEOUT = 10;
    protected  JavascriptExecutor js = (JavascriptExecutor) getDriver();
    protected ActionHelper(){}
    protected  WebDriver getDriver() {
        if (DriverConnector.driver == null){
            DriverConnector.setUpDriver();
        }
        return DriverConnector.driver;
    }
    protected  String getTitle() {
        return DriverConnector.driver.getTitle();
    }
    public  void clickBtn(By element) {

        DriverConnector.driver.findElement(element).click();
    }

    protected  void clickListElement(int itemIndex,By element) {
        DriverConnector.driver.findElements(element).get(itemIndex).click();
    }

    protected  void setText(By element, String textValue) {
        DriverConnector.driver.findElement(element).sendKeys(textValue);
    }


    protected  void scrollToElement(By element) {
        try {
            js.executeScript("arguments[0].scrollIntoView();",element );
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    protected  void waitThread() {
        try {
            Thread.sleep(2000);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }



    protected void clearText(By element) {
        DriverConnector.driver.findElement(element).clear();
    }
    public String getElementText(By element) {
        return DriverConnector.driver.findElement(element).getText();
    }

    protected void selectElementIndex(By element,int index) {
        WebElement testDropDown = getDriver().findElement(element);
        Select dropdown = new Select(testDropDown);
        dropdown.selectByIndex(index);
    }


    protected Boolean IsDisplayedABoolean(By element) {
        return DriverConnector.driver.findElement(element).isDisplayed();
    }


    protected  void waiting(){
        DriverConnector.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
    }
}
