package serenitylabs.tutorials.trains.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class StatusUpdatesPage {
    public static final Target SERVICE_LINES = Target.the("Service Lines").located(By.className("service-name"));
}
