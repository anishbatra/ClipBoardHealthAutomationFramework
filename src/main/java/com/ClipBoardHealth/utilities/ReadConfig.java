package com.ClipBoardHealth.utilities;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {


    public Properties pro;
    public static Logger logger;

    public ReadConfig() {
        logger = Logger.getLogger(this.getClass());
        File src = new File("./Configuration/config.properties");
        try {
            FileInputStream fis = new FileInputStream(src);
            pro = new Properties();
            pro.load(fis);
        } catch (Exception e) {
            System.out.println("Exception is" + e.getMessage());
        }
    }

    public String getApplicationURL() {
        String url = pro.getProperty("baseURL");
        logger.info(">>>>>>>>>>>>>URL opened>>>>>>>>>>>>>>>");
        return url;
    }

    public String getChromePath() {
        String chromePath = pro.getProperty("chromepath");
        return chromePath;
    }

    public String getFirefoxPath() {
        String chromePath = pro.getProperty("firefoxpath");
        return chromePath;
    }


}
