package tasks;

import entities.Product;
import entities.ShoppingCart;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;


public class AddToCartTask implements Task
{
    private final ShoppingCart cart;



    public AddToCartTask(ShoppingCart cart) {
        this.cart = cart;
    }

    @Step("{0} attempts to buy product with product name Sauce Labs Backpack")
    public <T extends Actor> void performAs(T t)
    {
        List<Product> products = cart.getItems();

        for (Product product: products)
        {
            String productName = product.getName().replace(" ", "-").toLowerCase();

//            if (productName.equals("test.allthethings()-t-shirt-(red)"))
//            {
//                String escapedName = "//button[contains(@data-test, 'add-to-cart-test.allthethings()-t-shirt-(red)')]";
//
//                t.attemptsTo(
//                        Click.on(
//                                Target.the("Add to cart button for specific product")
//                                .locatedBy(escapedName)
//                        )
//                );
//            }

            t.attemptsTo(
                    Click.on("#add-to-cart-" +  productName)
            );
        }

        waitFor(2000);
    }

    public static AddToCartTask withDetails(ShoppingCart cart)
    {
        return instrumented(AddToCartTask.class, cart);
    }

    private void waitFor(int milliseconds)
    {
        try
        {
            Thread.sleep(milliseconds);
        }
        catch (InterruptedException e)
        {
            Thread.currentThread().interrupt();
        }
    }
}
