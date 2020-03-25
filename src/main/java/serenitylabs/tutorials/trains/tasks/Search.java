package serenitylabs.tutorials.trains.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;
import serenitylabs.tutorials.trains.ui.TFLHomePage;

public class Search {
    public static Performable forStation(String station) {
        return Task.where("{0} searches for station " + station,
                Enter.theValue(station).into(TFLHomePage.SEARCH).thenHit(Keys.ENTER)
        );
    }
}
