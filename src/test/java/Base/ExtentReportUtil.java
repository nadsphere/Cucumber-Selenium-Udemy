package Base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.*;
import java.nio.file.Files;


public class ExtentReportUtil extends BaseUtil{
    String fileName = reportLocation + "extent-report.html";

    public void ExtentReport(){
        // create ER
        extent = new ExtentReports();
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(fileName);
        htmlReporter.config().setTheme(Theme.DARK);
        htmlReporter.config().setDocumentTitle("Test Report for Selenium");
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName("Test Report");
        extent.attachReporter(htmlReporter);
    }

    public void ExtentReportScreenShot() throws IOException {
        var screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        Files.copy(screenShot.toPath(), new File(reportLocation + "screenshot.png").toPath());
        scenarioDef.fail("details").addScreenCaptureFromPath(reportLocation + "screenshot.png");
    }

    public void FlushReport(){
        extent.flush();
    }

}
