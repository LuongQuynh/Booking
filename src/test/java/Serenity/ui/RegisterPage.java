package Serenity.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;


@DefaultUrl("http://booking.com/")
public class RegisterPage extends PageObject {
    public static Target REGISTER_BUTTON = Target.the("Register button").locatedBy("//div[@class='sign_in_wrapper']");
    public static Target EMAIL_FIELD = Target.the("email address").located(By.id("login_name_register"));
    public static Target SUBMIT_BUTTON = Target.the("submit btn").locatedBy("//button[@type='submit']");
    public static Target PASSWORD_FIELD = Target.the("submit btn").locatedBy("//input[@id='password']");
    public static Target CONFIRM_PASSWORD_FIELD = Target.the("submit btn").locatedBy("//input[@id='confirmed_password']");
    public static Target CREATE_ACCOUNT_BUTTON = Target.the("submit btn").locatedBy("//button[@type='submit']");
}
