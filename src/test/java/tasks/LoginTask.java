package tasks;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actions.OpenUrl;
import org.openqa.selenium.Keys;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class LoginTask implements Task
{
    private final String username;
    private final String userPassword;


    public LoginTask(String username, String userPassword)
    {
        this.username = username;
        this.userPassword = userPassword;
    }

    @Step("{0} attempts to login with username #username and password #password")
    public <T extends Actor> void performAs(T t)
    {
        t.attemptsTo(
                Open.url("https://saucedemo.com"),
                Enter.theValue(username).into("#user-name"),
                Enter.theValue(userPassword).into("#password").thenHit(Keys.ENTER)
        );
    }

    public static LoginTask withCredentials(String username, String password)
    {
        return instrumented(LoginTask.class, username, password);
    }
}
