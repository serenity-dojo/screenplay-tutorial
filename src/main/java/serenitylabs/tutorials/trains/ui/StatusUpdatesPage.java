package serenitylabs.tutorials.trains.ui;

import net.serenitybdd.screenplay.targets.Target;

public class StatusUpdatesPage {
    public static final Target SERVICE_LINES = Target.the("Service lines")
            .locatedBy(".service-name span");
}
