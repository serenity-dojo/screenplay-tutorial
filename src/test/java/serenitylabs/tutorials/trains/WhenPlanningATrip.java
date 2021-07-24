package serenitylabs.tutorials.trains;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import net.serenitybdd.screenplay.questions.targets.TheTarget;
import net.thucydides.core.annotations.Managed;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import serenitylabs.tutorials.trains.ui.*;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SerenityRunner.class)
public class WhenPlanningATrip {

    @Managed
    WebDriver browser;

    Actor carrie = Actor.named("Carrie");

    @Before
    public void setTheStage() {
        carrie.can(BrowseTheWeb.with(browser));

        carrie.attemptsTo(
                Open.browserOn().the(TFLHomePage.class),
                Click.on(CookiesDialog.ACCEPT_ALL_COOKIES),
                Click.on(CookiesDialog.DONE)
        );
    }

    @Test
    public void the_TFL_page_title_should_be_visible() {

        carrie.should(
                seeThat(
                        TheWebPage.title(),
                        containsString("Transport for London")));
    }

    @Test
    public void the_status_updates_title_should_be_visible() {

        carrie.attemptsTo(
                Open.browserOn().the(TFLStatusPage.class)
        );
        carrie.should(
                seeThat(
                        TheWebPage.title(),
                        containsString("status updates")));
    }

    @Test
    public void should_be_able_to_search_for_station_details() {

        carrie.attemptsTo(
                Enter.theValue("Waterloo").into(TFLHomePage.SEARCH).thenHit(Keys.ENTER)
        );

        carrie.should(
                seeThat(
                        TheTarget.textOf(TFLSearchResultsPage.SEARCH_RESULTS_HEADING),equalTo("Search: Waterloo")
                )
        );
    }

    @Test
    public void should_list_all_relevant_station_information() {

        carrie.attemptsTo(
                Enter.theValue("Jubilee").into(TFLHomePage.SEARCH).thenHit(Keys.ENTER)
        );

        carrie.should(
                seeThat(
                        TheTarget.textOf(TFLSearchResultsPage.FIRST_ARTICLE_HEADING), containsString("Jubilee")
                )
        );
    }

    @Test
    public void should_see_status_updates(){
        carrie.attemptsTo(
                Click.on(MenuBar.STATUS_UPDATES)
        );

//        carrie.should(
//                seeThat(
//                        TheTarget.textValuesOf(StatusUpdatesPage.SERVICE_LINES),
//                        hasItems("Bakerloo","Circle","Central")
//                )
//        );
    }

}
