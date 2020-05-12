package Serenity.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage extends PageObject {
    public static Target LOGIN_BUTTON =   Target.the("login button").locatedBy("//div[@id='user_form']//li[@id='current_account']//div");
    public static Target EMAIL_FIELD =   Target.the("login button").located(By.id("username"));
    public static Target NEXT_BUTTON =   Target.the("login button").locatedBy("//button[@type='submit']");
    public static Target PASSWORD_FIELD =   Target.the("login button").located(By.id("password"));
    public static Target SUBMIT_BUTTON =   Target.the("login button").locatedBy("//button[@type='submit']");
}
