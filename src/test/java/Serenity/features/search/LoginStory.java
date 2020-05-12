package Serenity.features.search;

import Serenity.abilities.GetInfoLogin;
import Serenity.questions.DashBoard;
import Serenity.tasks.Login;
import Serenity.tasks.OpenTheApplication;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.Matchers.containsString;

@RunWith(SerenityRunner.class)
public class LoginStory {
    Actor anna = Actor.named("anna");
    @Managed
    public WebDriver herBrowser;
    @Steps
    OpenTheApplication openTheApplication;
    @Before
    public void annaCanOpenTheApplication(){
        anna.can(BrowseTheWeb.with(herBrowser))
                .whoCan(GetInfoLogin.fromHerLoginProfile());
    }

    @Test
    public void anna_want_to_login_to_Booking_page(){
        givenThat(anna).wasAbleTo(openTheApplication);
        when(anna).attemptsTo(
                Login.withHerProfile()
        );
        anna.should(
                seeThat(DashBoard.getTitle(),containsString(""))
        );

    }

}
