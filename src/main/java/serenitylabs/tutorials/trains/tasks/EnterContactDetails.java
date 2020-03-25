package serenitylabs.tutorials.trains.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import serenitylabs.tutorials.trains.ui.ContactForm;

public class EnterContactDetails {
    public static Performable forCustomer(String title, String firstName, String lastName) {
        return Task.where("{0} enters details for " + title + " " + lastName,
                SelectFromOptions.byVisibleText("Mrs").from(ContactForm.TITLE),
                Enter.theValue("Sarah-Jane").into(ContactForm.FIRST_NAME),
                Enter.theValue("Smith").into(ContactForm.LAST_NAME)
        );
    }
}
