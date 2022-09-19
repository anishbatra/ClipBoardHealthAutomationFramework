package com.ClipBoardHealth.utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverSetUp {
    ReadConfig readConfig = new ReadConfig();

    public String baseUrl = readConfig.getApplicationURL();


    public static WebDriver driver;
    public static Logger logger;

    public void setUp(String br, String rt) throws MalformedURLException {

        if (rt.equals("docker")) {
            URL url = new URL("http://localhost:4444/wd/hub");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            options.addArguments("enable-automation");
            options.addArguments("--headless");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-infobars");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--disable-browser-side-navigation");
            options.addArguments("--disable-gpu");
            driver = new RemoteWebDriver(url, options);
            driver.get(baseUrl);
        }
         System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")
                 + "/Drivers/chromedriver");
        if (br.equals("chrome") && rt.equals("local")) {
            System.setProperty("webdriver.chrome.driver", readConfig.getChromePath());
            driver = new ChromeDriver();
        } else if (br.equals("firefox") && rt.equals("local")) {
            System.setProperty("webdriver.gecko.driver", readConfig.getFirefoxPath());
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        logger = LogManager.getLogger("Insurance  Project");
        logger.info("***********Opened up the  browser***********");
        driver.get(baseUrl);

    }


    public void tearDown() {
        driver.quit();
        logger.info("browser closed");
    }
}
