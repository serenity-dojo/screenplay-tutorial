package serenitylabs.tutorials.trains.questions;

import net.serenitybdd.screenplay.Question;
import serenitylabs.tutorials.trains.ui.TFLSearchResultsPage;

import static net.serenitybdd.screenplay.questions.targets.TheTarget.textOf;

public class TheSearchResults {
    public static Question<String> heading() {
        return textOf(TFLSearchResultsPage.SEARCH_RESULTS_HEADING);
    }
}
