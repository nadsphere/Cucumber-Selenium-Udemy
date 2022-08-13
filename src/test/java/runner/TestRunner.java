package runner;

import io.cucumber.testng.*;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = {"classpath:features"},
        plugin = {
                "pretty",
                "json:target/cucumber/cucumber.json",
                "html:target/cucumber/cucumber-html-rep.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
        tags = "@Debug",
        glue = {"Steps"}
)

public class TestRunner extends AbstractTestNGCucumberTests {
    // run parallel
    @Override
    @DataProvider (parallel = true)
    public Object[][] scenarios(){
        return super.scenarios();
    }
}
