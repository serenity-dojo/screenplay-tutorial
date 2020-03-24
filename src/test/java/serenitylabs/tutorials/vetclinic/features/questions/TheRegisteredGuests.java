package serenitylabs.tutorials.vetclinic.features.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import serenitylabs.tutorials.vetclinic.model.Pet;
import serenitylabs.tutorials.vetclinic.model.PetHotel;

import java.util.List;

public class TheRegisteredGuests implements Question<List<Pet>> {
    private PetHotel petHotel;

    public TheRegisteredGuests(PetHotel petHotel) {

        this.petHotel = petHotel;
    }

    public static TheRegisteredGuests in(PetHotel petHotel) {
        return new TheRegisteredGuests(petHotel);
    }

    @Override
    public String getSubject() {
        return "the pets registered in " + petHotel.getHotelName();
    }

    @Override
    public List<Pet> answeredBy(Actor actor) {
        return petHotel.getPets();
    }
}
