package steps;


import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import tasks.BuyingTask;


@ExtendWith(SerenityJUnit5Extension.class)
public class BuyingSteps
{
    @BeforeEach
    public void setTheStage()
    {
        OnStage.setTheStage(new OnlineCast());
    }

    @Test
    public void buyingProduct()
    {
        setTheStage();

        Actor user = OnStage.theActorCalled("User");

        user.attemptsTo(
                BuyingTask.withDetails("Sauce Labs Backpack", "Luis", "Asmat", "13007")
        );
    }

}
