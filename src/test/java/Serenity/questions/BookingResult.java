package Serenity.questions;

import Serenity.ui.BookingResultPage;
import net.serenitybdd.screenplay.Question;

public class BookingResult {
    public static Question<String> totalRoom() {
        return actor-> BookingResultPage.NUMBER_OF_ROOM_RESULT.resolveFor(actor).getText();
    }
}
