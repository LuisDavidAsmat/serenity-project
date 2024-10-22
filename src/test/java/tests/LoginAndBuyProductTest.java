package tests;

import org.junit.jupiter.api.Test;
import steps.BuyingSteps;
import steps.LoginSteps;

import net.serenitybdd.annotations.Steps;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Scanner;

@ExtendWith(SerenityJUnit5Extension.class)
public class LoginAndBuyProductTest
{
    @Steps
    LoginSteps loginSteps;

    @Steps
    BuyingSteps buyingSteps;

    @Test
    public void testLoginAndBuyingProduct ()
    {
        loginSteps.loginToPage();
        buyingSteps.buyingProduct();

    }
}
