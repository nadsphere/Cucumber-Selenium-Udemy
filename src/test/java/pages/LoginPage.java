package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class LoginPage {
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.NAME, using = "UserName")
    public WebElement txtUserName;

    @FindBy(how = How.NAME, using = "Password")
    public WebElement txtPassWord;

    @FindBy(how = How.NAME, using = "Login")
    public WebElement btnLogin;

    public void Login(String userName, String password) throws Exception{
        txtUserName.sendKeys(userName);
        Thread.sleep(2000);
        txtPassWord.sendKeys(password);
        Thread.sleep(2000);
    }

    public void ClickLogin(){
        btnLogin.submit();
    }
}
