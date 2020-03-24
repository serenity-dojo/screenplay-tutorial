package serenitylabs.tutorials.vetclinic.model;


public class APetHotel {
    public static PetHotelBuilder called(String name) {
        return new PetHotelBuilder(name);
    }

    public static class PetHotelBuilder {
        private String name;

        public PetHotelBuilder(String name) {
            this.name = name;
        }

        public PetHotel withResidents(int residentCount) {
            PetHotel petHotel = PetHotel.called(name);
            for(int i = 1; i <= residentCount; i++) {
                petHotel.checkIn(Pet.cat().named("Cat " + i));
            }
            return petHotel;
        }
    }
}
