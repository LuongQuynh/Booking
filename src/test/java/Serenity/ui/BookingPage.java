package Serenity.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

public class BookingPage extends PageObject {

    public static Target SEARCH_FIELD = Target.the("Destination").located(By.id("ss"));
    public static Target SUGGEST_LOCATION = Target.the("dropdown of location").locatedBy("//ul[@role='listbox']/li[1]");
    public static Target DATE_FIELD = Target.the("Date picker").locatedBy("div[data-view=\"accommodation\"] div[data-mode=\"checkin\"]");
    public static Target SELECT_DAY = Target.the("").locatedBy("//td[@data-date=\"{0}\"]");
    public static Target SEARCH_BUTTON = Target.the("search butoon").locatedBy(".sb-searchbox__button ");
    public static Target MEMBER= Target.the("selec member").located(By.id("xp__guests__toggle"));

    public static Target NUMBER_OF_ADULT= Target.the("").locatedBy(".bui-stepper__display");
    public static Target INCREASE_NUMBER_OF_ALDULT = Target.the("add more than one people").locatedBy("//button[2][@type='button']");
    public static Target DECREASE_NUMBER_OF_ALDULT = Target.the("reduce more than one people").locatedBy("//button[1][@type='button']");

    //child
    public static Target NUMBER_OF_CHILD = Target.the("amount of children").locatedBy("//div[@class='sb-group__field sb-group-children ']//span[@class='bui-stepper__display']");
    public static Target INCREASE_NUMBER_OF_CHILDREN = Target.the("add more than one chidren").locatedBy("//div[@class='sb-group__field sb-group-children ']//button[2]");
    public static Target DECREASE_NUMBER_OF_CHILDREN = Target.the("reduce number of children").locatedBy("//div[@class='sb-group__field sb-group-children ']//button[1]");
    //room
    public static Target NUMBER_OF_ROOM= Target.the("amount of rooms").locatedBy("//div[@class='sb-group__field sb-group__field-rooms']//span[@class='bui-stepper__display']");
    public static Target INCREASE_NUMBER_OF_ROOM = Target.the("add more than one room").locatedBy("//div[@class='sb-group__field sb-group__field-rooms']//button[2]");
    public static Target DECREASE_NUMBER_OF_ROOM = Target.the("reduce number of room").locatedBy("//div[@class='sb-group__field sb-group__field-rooms']//button[1]");

}
