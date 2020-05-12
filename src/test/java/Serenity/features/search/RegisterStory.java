package Serenity.features.search;

import Serenity.abilities.GetInfoRegister;
import Serenity.questions.RegisterResult;
import Serenity.tasks.OpenTheApplication;
import Serenity.tasks.Register;
import Serenity.tasks.RegisterExistentAccount;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SerenityRunner.class)
public class RegisterStory {
    Actor anna = Actor.named("anna");
    @Managed
    public WebDriver herBrowser;
    @Steps
    OpenTheApplication openTheApplication;
    @Before
    public void annaCanOpenTheApplication(){
        anna.can(BrowseTheWeb.with(herBrowser))
        .whoCan(GetInfoRegister.fromRegisterProfile());
    }

    @Test
    @Ignore
    public void register_account_which_has_not_existed(){
                givenThat(anna).wasAbleTo(openTheApplication);
                when(anna).attemptsTo(
                        Register.withHerInfo()
                );
                anna.should(
                        seeThat(RegisterResult.titleOfPage(),equalTo(""))
                );
    }
    @Test
    public void register_account_which_is_existed(){
        givenThat(anna).wasAbleTo(openTheApplication);
        when(anna).attemptsTo(
                RegisterExistentAccount.withExistentAccount()
        );
        anna.should(
                seeThat(RegisterResult.errorMessage(),containsString("You already have a Booking.com account"))
        );
    }


}
