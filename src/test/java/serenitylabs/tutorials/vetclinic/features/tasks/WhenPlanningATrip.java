package serenitylabs.tutorials.vetclinic.features.tasks;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import net.serenitybdd.screenplay.questions.targets.TheTarget;
import net.serenitybdd.screenplay.waits.Wait;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.waits.WaitUntilTargetIsReady;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Screenshots;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import serenitylabs.tutorials.vetclinic.CookiesDialog;
import serenitylabs.tutorials.vetclinic.TFLHomePage;
import serenitylabs.tutorials.vetclinic.TFLSearchResultsFirstURLPage;
import serenitylabs.tutorials.vetclinic.TFLSearchResultsPage;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.hamcrest.Matchers.*;

@RunWith(SerenityRunner.class)
public class WhenPlanningATrip {

    @Managed (driver = "chrome")
    WebDriver browser;

    Actor carrie = Actor.named("Carrie");

    @Before
    public void setTheStage() {
        carrie.can(BrowseTheWeb.with(browser));
    }

    @Test
    public void the_TFL_page_title_should_be_visible(){

        carrie.attemptsTo(Open.browserOn().the(TFLHomePage.class));
        carrie.should(seeThat(TheWebPage.title(),containsString("Transport for London")));

    }

    @Test
    @Screenshots(disabled=true)
    public void the_TFL_Status_page_title_should_be_visible(){
        carrie.can(BrowseTheWeb.with(browser));
        carrie.attemptsTo(Open.url("https://tfl.gov.uk/tube-dlr-overground/status/"));
        carrie.should(seeThat(TheWebPage.title(),containsString("status updates")));

    }

    @Test
    public void should_be_able_to_search_for_station_details() throws InterruptedException {

        carrie.attemptsTo(Open.browserOn().the(TFLHomePage.class),
                Enter.theValue("Waterloo").into(TFLHomePage.SEARCH).thenHit(Keys.ENTER)
                        );

        carrie.should(
                seeThat(
                        TheTarget.textOf(TFLSearchResultsPage.SEARCH_RESULTS_HEADING),
                        equalTo("Search: Waterloo")
                )
        );
//        carrie.attemptsTo(
//                Click.on(CookiesDialog.ACCEPT_ALL_COOKIES),
//                Click.on(CookiesDialog.DONE)
//                        );
//
//        carrie.attemptsTo(
//                Click.on(CookiesDialog.ACCEPT_ALL_COOKIES),
//                WaitUntil.the(CookiesDialog.DONE, isVisible()),
//                //WaitUntil.the(CookiesDialog.DONE, isClickable()),
//                Click.on(CookiesDialog.DONE)
//        );

    }

    @Test
    public void should_list_all_relevant_station_information(){
        carrie.attemptsTo(Open.browserOn().the(TFLHomePage.class),
                Enter.theValue("Jubilee").into(TFLHomePage.SEARCH).thenHit(Keys.ENTER)
        );

        JavascriptExecutor jse = (JavascriptExecutor)browser;
        jse.executeScript("arguments[0].click()", TFLSearchResultsPage.TEST);

        carrie.attemptsTo(

                Click.on(TFLSearchResultsPage.FIRST_SEARCH_RESULT_LINK));

        carrie.should(
                seeThat(TheWebPage.title(),containsString("Jubilee"))
        );

    }
}
