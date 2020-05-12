package Serenity.features.search;

import Serenity.abilities.GetInformation;
import Serenity.questions.BookingResult;
import Serenity.tasks.Booking;
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
public class BookingStory {
    Actor anna= Actor.named("anna");
    @Managed
    public WebDriver herBrowser;
    @Steps
    OpenTheApplication openTheApplication;

    @Before
    public void annaCanOpenTheBookingPage(){
        anna.can(BrowseTheWeb.with(herBrowser))
        .whoCan(GetInformation.fromUserProfile());
    }

    @Test
    public void seek_accommodation_for_her_travel(){
        givenThat(anna).wasAbleTo(openTheApplication);
        when(anna).attemptsTo(Booking.withUserInfo());
        anna.should(
                seeThat(BookingResult.totalRoom(),containsString("20"))
        );
    }


}
