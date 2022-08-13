package Steps;

import Base.BaseUtil;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.*;

import java.util.List;

public class LoginSteps extends BaseUtil {
    private final BaseUtil base;
    private String strUrl;
    public LoginSteps(BaseUtil base) {
        this.base = base;
    }

    @Given("I navigate to login page")
    public void iNavigateToLoginPage() {
        System.out.println("Navigate to login page");
        strUrl = "https://demosite.executeautomation.com/";
        base.driver.navigate().to(strUrl);
        base.driver.manage().window().maximize();
    }

    @And("I enter following for login")
    public void iEnterFollowingForLogin(DataTable dataTable) throws Exception {
        List<List<String>> data = dataTable.cells();
        LoginPage page = new LoginPage(base.driver);
        page.Login(data.get(1).get(0), data.get(1).get(1));
    }

    @When("I click login button")
    public void iClickLoginButton() {
        LoginPage page = new LoginPage(base.driver);
        page.ClickLogin();
    }

    @Then("I should see user form page")
    public void iShouldSeeUserFormPage() throws Exception {
        UserForm uf = new UserForm(base.driver);
        Assert.assertTrue(uf.displayTitleForm(), "Is not displayed");
        Thread.sleep(3000);
    }

    @Then("I should see user form page wrongly")
    public void iShouldSeeUserFormPageWrongly() throws Exception {
        LoginPage page = new LoginPage(base.driver);
        Assert.assertTrue(page.getTitleForm(), "Is not displayed");
        Thread.sleep(3000);
    }
}
