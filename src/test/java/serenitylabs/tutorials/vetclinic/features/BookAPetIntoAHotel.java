package serenitylabs.tutorials.vetclinic.features;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import org.junit.Test;
import org.junit.runner.RunWith;
import serenitylabs.tutorials.vetclinic.features.questions.TheRegisteredGuests;
import serenitylabs.tutorials.vetclinic.features.tasks.CheckIn;
import serenitylabs.tutorials.vetclinic.model.Pet;
import serenitylabs.tutorials.vetclinic.model.PetHotel;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;

@RunWith(SerenityRunner.class)
public class BookAPetIntoAHotel {

    @Test
    public void petra_books_her_pet_cat_into_the_hotel() {

        // GIVEN

        Actor petra = Actor.named("Petra the pet owner");
        Pet ginger = Pet.cat().named("Ginger");
        PetHotel petHotel = PetHotel.called("Pet Hotel California");

        // WHEN
        petra.attemptsTo(
                CheckIn.aPet(ginger).into(petHotel)
        );

        // THEN
        //assertThat(petHotel.getPets(), hasItem(ginger));
        petra.should(seeThat(TheRegisteredGuests.in(petHotel), hasItem(ginger)));

    }
}
