package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = {"classpath:features"},
        plugin = {"pretty", "json:target/cucumber/cucumber.json", "html:target/cucumber/cucumber.html"},
        glue = {"Steps"})

public class TestRunner extends AbstractTestNGCucumberTests {
    // run parallel
    @Override
    @DataProvider (parallel = true)  // 2 scenario dijalankan sekaligus
    public Object[][] scenarios(){
        return super.scenarios();
    }
}
