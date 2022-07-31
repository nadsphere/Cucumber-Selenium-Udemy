package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class UserForm {
    public UserForm(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    @FindBy(how = How.XPATH, using = "//h2[contains(text(),'User Form')]")
    public WebElement titleUserForm;

    public boolean displayTitleForm() {
        titleUserForm.isDisplayed();
        return true;
    }
}
