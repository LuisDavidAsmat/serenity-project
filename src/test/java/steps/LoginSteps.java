package steps;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import tasks.BuyingTask;
import tasks.LoginTask;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import net.serenitybdd.junit5.SerenityJUnit5Extension;


@ExtendWith(SerenityJUnit5Extension.class)
public class LoginSteps
{
    @BeforeEach
    public void setTheStage()
    {
        OnStage.setTheStage(new OnlineCast());
    }

    @Test
    public void loginToPage()
    {
        setTheStage();

        Actor user = OnStage.theActorCalled("User");

        user.attemptsTo(LoginTask.withCredentials("standard_user", "secret_sauce"));
    }
}
