package serenitylabs.tutorials.trains.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

public class CookiesDialog extends PageObject {
    public static final By ACCEPT_ALL_COOKIES = By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll");
    public static final By DONE = By.xpath("//button[@onclick='endCookieProcess(); return false;']");
}