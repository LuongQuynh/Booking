package Serenity.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class BookingResultPage extends PageObject {
    public static Target NUMBER_OF_ROOM_RESULT = Target.the("Total of rooms").locatedBy("//div[@data-block-id='heading']//h1");

}
