package serenitylabs.tutorials.trains.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class MenuBar {
    public static final Target STATUS_UPDATES = Target.the("Status update menu")
            .located(By.linkText("Status updates"));
}
