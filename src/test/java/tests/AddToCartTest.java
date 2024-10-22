package tests;

import net.serenitybdd.annotations.Steps;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import steps.AddToCartSteps;
import steps.LoginSteps;

@ExtendWith(SerenityJUnit5Extension.class)
public class AddToCartTest
{
    @Steps
    LoginSteps loginSteps;

    @Steps
    AddToCartSteps addToCartSteps;

    @Test
    public void testLoginAndBuyingProduct ()
    {
        loginSteps.loginToPage();
        addToCartSteps.addProductsToCart();
    }
}
