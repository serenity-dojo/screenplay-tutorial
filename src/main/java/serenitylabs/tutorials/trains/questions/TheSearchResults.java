package serenitylabs.tutorials.trains.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.targets.TheTarget;
import serenitylabs.tutorials.trains.ui.TFLSearchResultsPage;

import static org.hamcrest.Matchers.equalTo;

public class TheSearchResults {
    public static <T> Question<String> heading() {
        return TheTarget.textOf(TFLSearchResultsPage.SEARCH_RESULTS_HEADING);
    }
}
