package pages;

import Base.BaseUtil;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class LoginPage {
    private final WebDriver driver;
    private final int timeout;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        BaseUtil base = new BaseUtil();
        this.timeout = Integer.parseInt(base.getConfig("wait.timeout", "10"));
    }

    @FindBy(how = How.NAME, using = "UserName")
    public WebElement txtUserName;

    @FindBy(how = How.NAME, using = "Password")
    public WebElement txtPassWord;

    @FindBy(how = How.NAME, using = "Login")
    public WebElement btnLogin;

    @FindBy(how = How.XPATH, using = "//h2[contains(text(),'User 123')]")
    public WebElement titleForm;

    private WebElement waitForElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void Login(String userName, String password) {
        waitForElement(txtUserName).sendKeys(userName);
        waitForElement(txtPassWord).sendKeys(password);
    }

    public void ClickLogin() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.elementToBeClickable(btnLogin)).submit();
    }

    public boolean getTitleForm() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOf(titleForm));
        return titleForm.isDisplayed();
    }
}
