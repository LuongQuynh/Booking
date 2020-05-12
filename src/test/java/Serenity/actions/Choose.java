package Serenity.actions;

import Serenity.abilities.GetInformation;
import Serenity.ui.BookingPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.EnterValue;
import net.serenitybdd.screenplay.actions.EnterValueIntoTarget;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;


public class Choose implements Interaction {
    LocalDate date;
    String dateFormat;
    public Choose(LocalDate date){
        this.date=date;
        DateTimeFormatter formatedDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.dateFormat=this.date.format(formatedDate);
    }


    @Override
    @Step("{0} fill out duration of holiday")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BookingPage.SELECT_DAY.of(this.dateFormat))

        );
//        WaitUntil.the(BookingPage.DATE_FIELD, isVisible()).forNoMoreThan(10).seconds(),



    }
    public static Choose fromDate(LocalDate checkInDate){
        return instrumented(Choose.class,checkInDate);
    }
    public static Choose toDate(LocalDate checkOutDate){
        return instrumented(Choose.class,checkOutDate);
    }
}
