package serenitylabs.tutorials.trains.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public enum MenuBar {
    STATUS_UPDATES(By.linkText("Status updates")),
    HELP_AND_CONTACTS(By.linkText("Help & contacts"));

    private final By byLocator;

    MenuBar(By byLocator) {
        this.byLocator = byLocator;
    }

    public Target menuOption() {
        return Target.the(name()).located(byLocator);
    }
}
