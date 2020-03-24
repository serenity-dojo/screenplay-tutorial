package serenitylabs.tutorials.vetclinic.features.questions;

import serenitylabs.tutorials.vetclinic.model.PetHotel;

public class TheGuests {
    public static TheRegisteredGuests registerdInTheHotel(PetHotel petHotel) {
        return TheRegisteredGuests.in(petHotel);
    }

    public static TheGuestsOnTheWaitingList onTheWaitingListAt(PetHotel petHotel) {
        return TheGuestsOnTheWaitingList.forHotel(petHotel);
    }
}
