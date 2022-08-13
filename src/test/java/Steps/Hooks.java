package Steps;

import Base.BaseUtil;
import io.cucumber.java.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.*;

public class Hooks extends BaseUtil {
    private final BaseUtil base;

    public Hooks(BaseUtil base) {
        this.base = base;
    }

    @Before
    public void InitializeTest(){
        System.out.println("Opening the browser: Chrome");
        base.driver = new ChromeDriver();
    }

    @BeforeStep
    public void BeforeTestExecution(Scenario scenario){
        System.out.println("The execution scenario step Before: " + scenario.getLine());
    }

    @After
    public void AfterTest(){
        base.driver.quit();
    }

    @AfterStep
    public void AddScreenshot(Scenario scenario) throws IOException {
        WebDriver driver = base.driver;
        if(scenario.isFailed()){
            File sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            byte [] fileContent = FileUtils.readFileToByteArray(sourcePath);
            scenario.attach(fileContent, "image/png", "image-failed");
        }
        System.out.println("The execution scenario step After: " + scenario.getLine());
    }
}
