package Serenity.questions;

import Serenity.ui.RegisterResultPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class RegisterResult{
    public static Question<String> titleOfPage() {
        return actor -> RegisterResultPage.TITLE_OF_PAGE.resolveFor(actor).getText();

    }

    public static Question errorMessage() {
        return actor -> RegisterResultPage.ERROR_MESSAGE.resolveFor(actor).getText();
    }
}
