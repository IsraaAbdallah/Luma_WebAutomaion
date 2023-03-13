package com.luma.utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverConnector {



    public static Properties props = new Properties();
    public static WebDriver driver;
    public final static int TIMEOUT = 15;
    public static JavascriptExecutor js;

    public DriverConnector() {

    }

    public static void setUpDriver() {
        try {
            props = new Properties();
            System.out.println("super constructor invoked");
            File file = new File("src/test/resources/properities/config.properities");
            FileInputStream fis = new FileInputStream(file);
            props.load(fis);

        } catch (IOException e) {
            e.printStackTrace();
        }

        String browserName = props.getProperty("browser");
        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();

            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("IE")) {
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
        } else {
            System.out.println("choose you browser");
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
        System.out.println("driver: " + driver);

    }




    public static void openPage() {
        driver.get(props.getProperty("url"));
    }

    public static WebDriver getDriver() {
        if (driver == null){
            setUpDriver();
        }
        return driver;
    }
    public static String getTitle() {
        return driver.getTitle();
    }


    public static void tearDown() {

        if (driver != null) {
            driver.close();
            driver.quit();
        }

        driver = null;
    }
}
