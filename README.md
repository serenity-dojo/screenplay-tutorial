# Screenplay Tutorial Project - asking questions

## Exercise 2

In this exercise, we will experiment with Question classes. We will implement a test that checks that, when the hotel is full, subsequent bookings are placed on a waiting list.

### Step 1
In the `WhenCheckingInToThePetHotel` test class, add a new test method called `petra_books_her_pet_cat_into_the_hotel_that_is_already_full()`:

```java
    @Test
    public void petra_books_her_pet_cat_into_the_hotel_that_is_already_full() {
    }
```

### Step 2

Add the actors and objects who will take part in this test. We will need Petra the pet owner, her cat Ginger, and a hotel manager called Harry:

```java
    @Test
    public void petra_books_her_pet_cat_into_the_hotel_that_is_already_full() {

        // CAST
        Actor petra = Actor.named("Petra the pet owner");
        Pet ginger = Pet.cat().named("Ginger");
        Actor harry = Actor.named("Harry the hotel manager");
    }
```

### Step 3
Use the provided `APetHotel` factory class to create a pet hotel with 30 residents in it:
```java
    // GIVEN
    PetHotel petHotel = APetHotel.called("Pet Hotel California").withResidents(20);
```

### Step 4

Now make Petra check in her pet cat Ginger:

```java
        // WHEN
        petra.attemptsTo(
                CheckIn.aPet(ginger).into(petHotel)
        );
```

### Step 5

Next, we want Harry to check that Ginger is on the waiting list and not among the current hotel residents. 
Although we could do this by querying the `petHotel` object directly, in this exercise we will use Questions. 
In a real-world test, Harry might need to query a REST end point or navigate to a UI screen to see these results, 
and this logic would be encapsulated inside the Question classes, so that the code below would not change.

Add the following code. It won't compile yet, but that's fine; we will create the `TheGuests` class in the next step:
 
```java
        // THEN
        harry.should(
                seeThat(TheGuests.onTheWaitingListAt(petHotel), hasItem(ginger)),
                seeThat(TheGuests.registerdInTheHotel(petHotel), not(hasItem(ginger)))
        );
```

### Step 6

Now create the `TheGuests` class. This is a factory class; each method will return a different Question object. 
We already have the `TheRegisteredGuests` class, but we will need to add `TheGuestsOnTheWaitingList`

```java

public class TheGuests {
    public static TheRegisteredGuests registerdInTheHotel(PetHotel petHotel) {
        return TheRegisteredGuests.in(petHotel);
    }

    public static TheGuestsOnTheWaitingList onTheWaitingListAt(PetHotel petHotel) {
        return TheGuestsOnTheWaitingList.forHotel(petHotel);
    }
}
```

Next, implement the `TheGuestsOnTheWaitingList` question class. Try to implement it yourself; you can use the `getWaitingList()` method to return the actual list of pets on the waiting list.
 
Now run the test and check that the correct reporting appears in the Serenity HTML report in the `target/site/serenity` directory.

## Exercise 3

Refactor the `petra_books_her_pet_cat_into_the_hotel()` to use the `should(seeThat(...))` construct.

## Exercise 4

Refactor the `petra_checks_her_cat_out_of_the_hotel()` to use the `should(seeThat(...))` construct.