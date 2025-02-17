package hu.gyeekclub.workshop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

// these tests test for code security: how much code allows itself to be misused
// As a wise man once said: thou shalt make thine code resilient to tardiness!
public class SecurityTests {

    @Test
    public void customerNullConstructorTest() {
        assertThrows(
            IllegalArgumentException.class,
            () -> {
                new Customer(null);
            },
            "Do not allow null parameters to stay unpunished."
        );
    }
    
    @Test
    public void movieNullConstructorTest() {
        assertThrows(
            IllegalArgumentException.class,
            () -> {
                new Movie(null, 0);
            },
            "Do not allow null parameters to stay unpunished."
        );
    }
    
    @Test
    public void rentalNullConstructorTest() {
        assertThrows(
            IllegalArgumentException.class,
            () -> {
                new Rental(null, 0);
            },
            "Do not allow null parameters to stay unpunished."
        );
    }
    
    @Test
    public void rentalZeroDayConstructorTest() {
        assertThrows(
            IllegalArgumentException.class,
            () -> {
                new Rental(new Movie("Movie the Movie", Movie.NEW_RELEASE), 0);
            },
            "Do not allow zero day to stay unpunished."
        );
    }
    
    @Test
    public void rentalNegativeDayConstructorTest() {
        assertThrows(
            IllegalArgumentException.class,
            () -> {
                new Rental(new Movie("Movie the Movie", Movie.NEW_RELEASE), -3);
            },
            "Do not allow zero day to stay unpunished."
        );
    }

    @Test
    public void nullParameterTest() {
        assertThrows(
            IllegalArgumentException.class,
            () -> {
                new Customer("Test").addRental(null);
            },
            "No not allow null parameters to stay unpunished."
        );
    }

    @Test
    public void illegalParameterTest() {
        assertThrows(
            IllegalArgumentException.class,
            () -> {
                Customer customer = new Customer("Test");
                Movie invalidMovie = new Movie("Nope", 80); // 80 is invalid
                customer.addRental(new Rental(invalidMovie, 5));
                customer.printBill();
            },
            "No not allow invalid parameters to happen."
        );
    }
}
