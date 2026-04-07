package Steps;

import Base.BaseUtil;
import io.cucumber.java.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.IOException;
import java.io.File;

public class Hooks extends BaseUtil {
    private final BaseUtil base;

    public Hooks(BaseUtil base) {
        this.base = base;
    }

    @Before
    public void InitializeTest() {
        String browser = base.getConfig("browser", "chrome").toLowerCase();
        boolean headless = Boolean.parseBoolean(base.getConfig("browser.headless", "false"));

        System.out.println("Opening the browser: " + browser + " (headless=" + headless + ")");

        switch (browser) {
            case "chrome" -> {
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                if (headless) {
                    options.addArguments("--headless=new");
                }
                base.driver = new ChromeDriver(options);
            }
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                base.driver = new FirefoxDriver();
            }
            case "edge" -> {
                WebDriverManager.edgedriver().setup();
                base.driver = new EdgeDriver();
            }
            default -> throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
    }

    @BeforeStep
    public void BeforeTestExecution(Scenario scenario) {
        System.out.println("The execution scenario step Before: " + scenario.getLine());
    }

    @After
    public void AfterTest() {
        if (base.driver != null) {
            base.driver.quit();
        }
    }

    @AfterStep
    public void AddScreenshot(Scenario scenario) throws IOException {
        WebDriver driver = base.driver;
        if (scenario.isFailed()) {
            File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
            scenario.attach(fileContent, "image/png", "image-failed");
        }
        System.out.println("The execution scenario step After: " + scenario.getLine());
    }
}
