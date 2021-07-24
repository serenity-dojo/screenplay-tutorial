package serenitylabs.tutorials.vetclinic;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CookiesDialog extends PageObject {
//    public static final Target ACCEPT_ALL_COOKIES = Target.the("Accept Cookies").located(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll"));
//    public static final Target DONE = Target.the("Done").located(By.partialLinkText("Done"));

    public static final By ACCEPT_ALL_COOKIES = By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll");
    public static final By DONE = By.className("cb-button");
}
