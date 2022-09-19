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

        if (rt.equalsIgnoreCase("docker")) {
            URL url = new URL("http://localhost:4444/wd/hub");
            ChromeOptions options = new ChromeOptions();
            options.setCapability("name", "chrome");
            options.addArguments("start-maximized");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--headless");
            driver = new RemoteWebDriver(url, options);
            driver.get(baseUrl);
        }
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")
                + "/Drivers/chromedriver");
        if (br.equalsIgnoreCase("chrome") && rt.equals("local")) {
            System.setProperty("webdriver.chrome.driver", readConfig.getChromePath());
            driver = new ChromeDriver();
        } else if (br.equalsIgnoreCase("firefox") && rt.equals("local")) {
            System.setProperty("webdriver.gecko.driver", readConfig.getFirefoxPath());
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        logger = LogManager.getLogger("ClipBoardHealth  Project");
        logger.info("***********Opened up the  browser***********");
        driver.get(baseUrl);

    }


    public void tearDown() {
        driver.quit();
        logger.info("browser closed");
    }
}
