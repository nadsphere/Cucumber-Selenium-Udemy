package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

// if you run with TestNG, just disable this command
//@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:features"},
        plugin = {"pretty", "json:target/cucumber/cucumber.json"},
        glue = {"Steps"})

public class TestRunner extends AbstractTestNGCucumberTests {
    // run parallel
    @Override
    @DataProvider (parallel = true)  // 2 scenario dijalankan sekaligus
    public Object[][] scenarios(){
        return super.scenarios();
    }
}