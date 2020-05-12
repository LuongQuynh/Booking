package Serenity.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class RegisterResultPage extends PageObject {
    public static  Target ERROR_MESSAGE = Target.the("error message").locatedBy("//div[@id='login_name_register-error']") ;
    public static Target TITLE_OF_PAGE = Target.the("title of page").locatedBy("//div[@class='header-wrapper']//img[@id='logo_no_globe_new_logo']");
}
