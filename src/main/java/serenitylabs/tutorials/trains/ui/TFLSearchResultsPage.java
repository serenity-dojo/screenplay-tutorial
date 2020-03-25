package serenitylabs.tutorials.trains.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

public class TFLSearchResultsPage extends PageObject {
    public static final Target SEARCH_RESULTS_HEADING = Target.the("Search headline")
            .locatedBy(".hero-headline");
}