package com.ClipBoardHealth.Data;

import com.ClipBoardHealth.utilities.ReadConfig;

public class InputData extends ReadConfig {


    public String browser = pro.getProperty("browser");
    public String runType = pro.getProperty("runType");
    public String homePageTitle = pro.getProperty("homePageTitle");


}
