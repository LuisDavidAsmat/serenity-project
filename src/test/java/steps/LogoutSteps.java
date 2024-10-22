package steps;


import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import tasks.LoginTask;


@ExtendWith(SerenityJUnit5Extension.class)
public class LogoutSteps
{
    @BeforeEach
    public void setTheStage()
    {
        OnStage.setTheStage(new OnlineCast());
    }

    @Test
    public void logoutFromPage()
    {
        setTheStage();

        Actor user = OnStage.theActorCalled("User");

        user.attemptsTo(
                Click.on("#react-burger-menu-btn")

        );
        waitFor(2000);
        user.attemptsTo(
                Click.on("#logout_sidebar_link")

        );
        waitFor(2000);
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
