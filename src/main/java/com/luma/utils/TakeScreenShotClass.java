package com.luma.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class TakeScreenShotClass {
    public static void screenShot(WebDriver driver, String fileName) {
        Date d = new Date();
        String dateName = d.toString().replace(":", "_").replace(" ", "_");//+ //".png"
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        try {

            FileUtils.copyFile(sourceFile, new File(System.getProperty("user.dir") + "\\ScreenShots\\" + fileName + "_" + dateName + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}