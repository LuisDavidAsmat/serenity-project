package org.example.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageObject
{
    @FindBy(id = "user-name")
    private WebElementFacade usernameUser;

    @FindBy(id = "password")
    private WebElementFacade userPassword;

    @FindBy(id = "login-button")
    private WebElementFacade loginBtn;

    public void enterUsername (String username)
    {
        usernameUser.type(username);
    }

    public void enterUserPassword (String password)
    {
        userPassword.type(password);
    }

    public void clickLogInBtn ()
    {
        loginBtn.click();
    }

}
