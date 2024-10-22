package tasks;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class BuyingTask implements Task
{
    private final String product;
    private final String firstName;
    private final String lastName;
    private final String postalCode;


    public BuyingTask(String product, String firstName, String lastName, String postalCode) {
        this.product = product;
        this.firstName = firstName;
        this.lastName = lastName;
        this.postalCode = postalCode;
    }

    @Step("{0} attempts to buy product with product name Sauce Labs Backpack")
    public <T extends Actor> void performAs(T t)
    {
        t.attemptsTo(
               Click.on("#add-to-cart-" +  product.replace(" ", "-").toLowerCase()),
                Click.on(".shopping_cart_link" )
        );

        waitFor(2000);
        t.attemptsTo(
                Click.on("#checkout"),
                Enter.theValue(firstName).into("#first-name"),
                Enter.theValue(lastName).into("#last-name"),
                Enter.theValue(postalCode).into("#postal-code")
        );

        waitFor(1500);
        t.attemptsTo(
                Click.on("#continue")
        );

        waitFor(1500);
        t.attemptsTo(

                Click.on("#finish")
        );

        waitFor(1500);
        t.attemptsTo(

                Click.on("#back-to-products")
        );
    }

    public static BuyingTask withDetails(String product, String firstName,
                                         String lastName, String postalCode)
    {
        return instrumented(BuyingTask.class, product, firstName, lastName, postalCode);
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
