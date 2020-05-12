package Serenity.actions;

import Serenity.abilities.GetInfoRegister;
import Serenity.ui.RegisterPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Input implements Interaction {
    private String email;
    private String password;
    private String confirmPassword;
    public Input(String email,String password,String confirmPassword){
        this.email=email;
        this.password=password;
        this.confirmPassword=confirmPassword;
    }
    public static RegisterBuilder withEmail(String email){
        return new RegisterBuilder(email);
    }
    public static class RegisterBuilder{
        private String email;
        private String password;
        public RegisterBuilder(String email){
            this.email=email;
        }
        public RegisterBuilder andPassword(String password){
            this.password=password;
            return this;
        }

        public Interaction thenConfirmPassword(String confirmPassword){
            return instrumented(Input.class,email,password,confirmPassword);
        }
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(this.email).into(RegisterPage.EMAIL_FIELD),
                Click.on(RegisterPage.SUBMIT_BUTTON),
                Enter.theValue(this.password).into(RegisterPage.PASSWORD_FIELD),
                Enter.theValue(this.confirmPassword).into(RegisterPage.CONFIRM_PASSWORD_FIELD)
        );

    }
    private GetInfoRegister getInfoRegister(Actor actor){
        return GetInfoRegister.getInfoRegister(actor);
    }
}
