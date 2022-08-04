package Steps;

import Base.BaseUtil;
import io.cucumber.java.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks extends BaseUtil {
    private BaseUtil base;

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

    @AfterStep
    public void AfterTestExecution(Scenario scenario){
        System.out.println("The execution scenario step After: " + scenario.getLine());
    }

    @After
    public void AfterTest(Scenario scenario){
        if(scenario.isFailed()){
            System.out.println(scenario.getName());
        }
        System.out.println("Closing the browser...");
        base.driver.quit();
    }
}
