package Serenity.tasks;

import Serenity.abilities.GetInfoLogin;
import Serenity.ui.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Login implements Task {
    public static Login withHerProfile() {
        return instrumented(Login.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(LoginPage.LOGIN_BUTTON),
                Enter.theValue(getInfoLogin(actor).getEmail()).into(LoginPage.EMAIL_FIELD),
                Click.on(LoginPage.NEXT_BUTTON),
                Enter.theValue(getInfoLogin(actor).getPassword()).into(LoginPage.PASSWORD_FIELD),
                Click.on(LoginPage.SUBMIT_BUTTON)

        );



    }

    private GetInfoLogin getInfoLogin(Actor actor){
        return GetInfoLogin.getInfoLogin(actor);
    }
}
