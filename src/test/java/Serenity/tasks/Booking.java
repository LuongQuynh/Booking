package Serenity.tasks;

import Serenity.abilities.GetInformation;
import Serenity.actions.Choose;
import Serenity.actions.Select;
import Serenity.ui.BookingPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Booking implements Task {

    @Override
    @Step("{0} looking for the destination which she want to go")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(userInformation(actor).getLocation()).into(BookingPage.SEARCH_FIELD),
                Click.on(BookingPage.SUGGEST_LOCATION),
                Choose.fromDate(userInformation(actor).getDepartureDay()),
                Choose.toDate(userInformation(actor).getReturnDay()),
                Select.noAdult(userInformation(actor).getNumAdult()).noChildren(userInformation(actor).getNumChildren()).noRoom(userInformation(actor).getNumRoom()),
                Click.on(BookingPage.SEARCH_BUTTON)

        );

    }

    public  static Booking withUserInfo(){
        return instrumented(Booking.class);
    }
    private GetInformation userInformation(Actor actor) {
        return GetInformation.getInformation(actor);
    }
}
