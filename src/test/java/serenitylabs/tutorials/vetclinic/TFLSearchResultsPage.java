package serenitylabs.tutorials.vetclinic;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class TFLSearchResultsPage extends PageObject {

    public static final Target SEARCH_RESULTS_HEADING = Target.the("Search Result").locatedBy(".hero-headline");

    public static final By TEST = By.xpath("//h2[@class='h3']");
    //public static final Target FIRST_SEARCH_RESULT_LINK = Target.the("First Search Result Link").locatedBy(".h3");
    public static final By FIRST_SEARCH_RESULT_LINK = By.xpath(".h3");

    public static final Target FIRST_ARTICLE_HEADING = Target.the("first article heading")
            .locatedBy(".h3");
}
