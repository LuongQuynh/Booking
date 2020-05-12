package Serenity.tasks;

import Serenity.abilities.GetInfoRegister;
import Serenity.actions.Input;
import Serenity.ui.RegisterPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Register implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(RegisterPage.REGISTER_BUTTON),
                Input.withEmail(getInfoRegister(actor).getEmail()).andPassword(getInfoRegister(actor).getPassword()).thenConfirmPassword(getInfoRegister(actor).getConfirmPassword()),
                Click.on(RegisterPage.CREATE_ACCOUNT_BUTTON));
    }
    private GetInfoRegister getInfoRegister(Actor actor){
        return GetInfoRegister.getInfoRegister(actor);
    }
    public static Register withHerInfo() {
        return instrumented(Register.class);
    }
}
