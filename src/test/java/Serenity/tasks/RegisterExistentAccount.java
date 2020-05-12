package Serenity.tasks;

import Serenity.abilities.GetInfoRegister;
import Serenity.ui.RegisterPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class RegisterExistentAccount implements Task {
    public static RegisterExistentAccount withExistentAccount() {
        return instrumented(RegisterExistentAccount.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
        Click.on(RegisterPage.REGISTER_BUTTON),
        Enter.theValue(getInfoRegister(actor).getEmail()).into(RegisterPage.EMAIL_FIELD),
        Click.on(RegisterPage.SUBMIT_BUTTON));

    }
    private GetInfoRegister getInfoRegister(Actor actor){
        return GetInfoRegister.getInfoRegister(actor);
    }
}
