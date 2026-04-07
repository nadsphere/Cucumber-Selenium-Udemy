package pages;

import Base.BaseUtil;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class UserForm {
    private final WebDriver driver;
    private final int timeout;

    public UserForm(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        BaseUtil base = new BaseUtil();
        this.timeout = Integer.parseInt(base.getConfig("wait.timeout", "10"));
    }

    @FindBy(how = How.XPATH, using = "//h2[contains(text(),'User Form')]")
    public WebElement titleUserForm;

    public boolean displayTitleForm() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOf(titleUserForm));
        return titleUserForm.isDisplayed();
    }
}
