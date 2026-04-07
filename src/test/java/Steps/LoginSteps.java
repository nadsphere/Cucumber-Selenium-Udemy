package Steps;

import Base.BaseUtil;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.*;

import java.util.List;

public class LoginSteps extends BaseUtil {
    private final BaseUtil base;

    public LoginSteps(BaseUtil base) {
        this.base = base;
    }

    @Given("I navigate to login page")
    public void iNavigateToLoginPage() {
        String url = base.getConfig("base.url");
        System.out.println("Navigate to login page: " + url);
        base.driver.navigate().to(url);
        base.driver.manage().window().maximize();
    }

    @And("I enter following for login")
    public void iEnterFollowingForLogin(DataTable dataTable) {
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
    public void iShouldSeeUserFormPage() {
        UserForm uf = new UserForm(base.driver);
        Assert.assertTrue(uf.displayTitleForm(), "User form page is not displayed");
    }

    @Then("I should see user form page wrongly")
    public void iShouldSeeUserFormPageWrongly() {
        LoginPage page = new LoginPage(base.driver);
        Assert.assertTrue(page.getTitleForm(), "User form page is not displayed");
    }
}
