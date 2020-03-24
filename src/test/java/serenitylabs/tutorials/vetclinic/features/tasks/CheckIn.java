package serenitylabs.tutorials.vetclinic.features.tasks;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.thucydides.core.annotations.Step;
import serenitylabs.tutorials.vetclinic.model.Pet;
import serenitylabs.tutorials.vetclinic.model.PetHotel;

public class CheckIn implements Performable {
    private Pet pet;
    private PetHotel petHotel;

    public CheckIn(){}

    public CheckIn(Pet pet, PetHotel petHotel) {
        this.pet = pet;
        this.petHotel = petHotel;
    }

    public static CheckInBuilder aPet(Pet pet) {
        return new CheckInBuilder(pet);
    }

    @Step("{0} checks in #pet to the hotel")
    @Override
    public <T extends Actor> void performAs(T actor) {
        petHotel.checkIn(pet);
    }

    public static class CheckInBuilder {
        private Pet pet;

        public CheckInBuilder(Pet pet) {
            this.pet = pet;
        }

        public Performable into(PetHotel petHotel) {
            return new CheckIn(pet,petHotel);
        }
    }
}