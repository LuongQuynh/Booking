package Serenity.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;


public class DashBoardResult extends PageObject {

    public static Target TITLE_OF_DASHBOARD = Target.the("title of dashboard").locatedBy("//span[@id='profile-menu-trigger--content']");
}
