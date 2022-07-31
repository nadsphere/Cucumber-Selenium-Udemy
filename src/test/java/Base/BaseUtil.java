package Base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;

public class BaseUtil {
    public WebDriver driver;
    public ExtentReports extent;
    public static ExtentTest scenarioDef;
    public static ExtentTest features;

    public static String
            reportLocation = "C:/Users/Nadia/Documents/Learn/Cucumber with Selenium Java Udemy (Basic)/cucumber-selenium-udemy/report/";
}