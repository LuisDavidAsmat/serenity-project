package tasks;

import entities.Product;
import entities.ShoppingCart;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import utils.WaitUtil;

import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;


public class DeleteFromCartTask implements Task
{
    private final ShoppingCart cart;

    public DeleteFromCartTask(ShoppingCart cart) {
        this.cart = cart;
    }

    @Step("{0} attempts to buy product with product name Sauce Labs Backpack")
    public <T extends Actor> void performAs(T t)
    {
        List<Product> products = cart.getItems();

        if (products.isEmpty())
        {
            return;
        }

        t.attemptsTo(
                Click.on(".shopping_cart_link")
        );

        WaitUtil.waitFor(2000);
        t.attemptsTo(
                Click.on("#continue-shopping")
        );

        for (Product product: products)
        {
            String productToRemove = product.getName().replace(" ", "-").toLowerCase();

            t.attemptsTo(
                    Click.on("#remove-" +  productToRemove)
            );
        }



        WaitUtil.waitFor(2000);
    }

    public static DeleteFromCartTask withDetails(ShoppingCart cart)
    {
        return instrumented(DeleteFromCartTask.class, cart);
    }

}

