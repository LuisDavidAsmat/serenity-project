package steps;


import entities.Product;
import entities.ShoppingCart;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import tasks.AddToCartTask;
import tasks.DeleteFromCartTask;

@ExtendWith(SerenityJUnit5Extension.class)
public class DeleteFromCartSteps
{
    @BeforeEach
    public void setTheStage()
    {
        OnStage.setTheStage(new OnlineCast());
    }

    @Test
    public void deleteProductsThemFromCart()
    {
        setTheStage();

        Actor user = OnStage.theActorCalled("User");

        ShoppingCart cart = new ShoppingCart();
        cart.addProduct(new Product("Sauce Labs Backpack"));
        cart.addProduct(new Product("Sauce Labs Bike Light"));
        cart.addProduct(new Product("Sauce Labs Bolt T-Shirt"));
        cart.addProduct(new Product("Sauce Labs Fleece Jacket"));

        user.attemptsTo(
                DeleteFromCartTask.withDetails(cart)
        );
    }


}
