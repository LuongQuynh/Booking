package Serenity.actions;

import Serenity.ui.BookingPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Select implements Interaction {
    private int adult;
    private int child;
    private int room;
    public Select(int adult,int child,int room){
        this.adult=adult;
        this.child=child;
        this.room=room;
    }
    public static GuestBuilder noAdult(int adult)
    {
        return new GuestBuilder(adult);
    }


    @Step("{0} provide number of people and room")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BookingPage.MEMBER)
        );
        int numberOfAdult = Integer.parseInt(BookingPage.NUMBER_OF_ADULT.resolveFor(actor).getText());
        if(numberOfAdult>adult){
            for(int i=numberOfAdult;i>adult;i--){
                BookingPage.DECREASE_NUMBER_OF_ALDULT.resolveFor(actor).click();
            }
        }else if(numberOfAdult<adult){
            for (int i = numberOfAdult; i <adult ; i++) {
                BookingPage.INCREASE_NUMBER_OF_ALDULT.resolveFor(actor).click();
            }
        }

        //child
        int numberOfChildren = Integer.parseInt(BookingPage.NUMBER_OF_CHILD.resolveFor(actor).getText());
        if(numberOfChildren>child){
            for (int i = numberOfChildren; i > child; i--) {
                BookingPage.DECREASE_NUMBER_OF_CHILDREN.resolveFor(actor).click();

            }

        }else if (numberOfChildren<child){
            for (int i = numberOfChildren; i <child ; i++) {
                BookingPage.INCREASE_NUMBER_OF_CHILDREN.resolveFor(actor).click();

            }
        }
        //room

        int numberOfRoom= Integer.parseInt(BookingPage.NUMBER_OF_ROOM.resolveFor(actor).getText());
        if (numberOfRoom>room){
            for (int i = numberOfRoom; i > room ; i--) {
                BookingPage.DECREASE_NUMBER_OF_ROOM.resolveFor(actor).click();

            }
        }else if (numberOfRoom<room){
            for (int i = numberOfRoom; i < room; i++) {
                BookingPage.INCREASE_NUMBER_OF_ROOM.resolveFor(actor).click();
            }
        }

    }
    public static class GuestBuilder
    {
        private int adult;
        private int child;
        private int room;

        public GuestBuilder(int adult)
        {
            this.adult = adult;
        }

        public Interaction noRoom(int room)
        {
            return instrumented(Select.class, adult, child,room);
        }

        public GuestBuilder noChildren(int child)
        {
            this.child = child;
            return this;
        }
    }
}
