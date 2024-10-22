package tests;

import net.serenitybdd.annotations.Steps;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import steps.LoginSteps;
import steps.LogoutSteps;


@ExtendWith(SerenityJUnit5Extension.class)
public class LogInLogOutTest
{
    @Steps
    LoginSteps loginSteps;

    @Steps
    LogoutSteps logoutSteps;

    @Test
    public void LoginLogoutFromPage ()
    {
        loginSteps.loginToPage();
        logoutSteps.logoutFromPage();
    }
}
