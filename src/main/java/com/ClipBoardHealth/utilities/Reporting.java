package com.ClipBoardHealth.utilities;

//Listener class used to generate Extent reports

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.ClipBoardHealth.utilities.DriverSetUp.driver;

public class Reporting extends TestListenerAdapter {
    public ExtentSparkReporter htmlReporter;
    public ExtentReports extent;
    public ExtentTest logger;

    public static void captureScreen(WebDriver driver, String tname) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
        FileUtils.copyFile(source, target);
        System.out.println("Screenshot taken");
    }

    public void onStart(ITestContext testContext) {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());// time stamp
        String repName = "Test-Report-" + timeStamp + ".html";
        //String repName = "Test-Report.html";

        htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/" + repName);// specify
        // location
        // of the
        // report
        try {
            htmlReporter.loadXMLConfig(System.getProperty("user.dir") + "/extent-config.xml");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        extent = new ExtentReports();

        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Host name", "localhost");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("user", "Anish");

        htmlReporter.config().setDocumentTitle("ClipBoardHealthProject"); // Title of report
        htmlReporter.config().setReportName("Functional Test Automation Report"); // name of the report
        // htmlReporter.config()).setTestViewChartLocation(Location.class); //location
        // of the chart
        htmlReporter.config().setTheme(Theme.DARK);
    }

    public void onTestSuccess(ITestResult tr) {
        logger = extent.createTest(tr.getName()); // create new entry in the report
        logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN)); // send the passed
        // information to the report
        // with GREEN color
        // highlighted
    }

    public void onTestFailure(ITestResult tr) {
        logger = extent.createTest(tr.getName()); // create new entry in the report
        logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED)); // send the passed information
        // to the report with GREEN
        // color highlighted
        try {
            captureScreen(driver, "screenshot");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String screenshotPath = System.getProperty("user.dir") + "/Screenshots/" + tr.getName() + ".png";

        File f = new File(screenshotPath);

        if (f.exists()) {
            logger.fail("Screenshot is below:" + logger.addScreenCaptureFromPath(screenshotPath));
        }

    }

    public void onTestSkipped(ITestResult tr) {
        logger = extent.createTest(tr.getName()); // create new entry in the report
        logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
    }

    public void onFinish(ITestContext testContext) {
        extent.flush();
    }

}

