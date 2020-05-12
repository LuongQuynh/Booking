package Serenity.questions;

import Serenity.ui.DashBoardResult;
import net.serenitybdd.screenplay.Question;

public class DashBoard {
    public static Question<String> getTitle() {
        return actor -> DashBoardResult.TITLE_OF_DASHBOARD.resolveFor(actor).getText();
    }
}
