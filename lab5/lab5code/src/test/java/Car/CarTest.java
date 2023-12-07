package Car;

import org.junit.Test;
import static org.junit.Assert.*;

public class CarTest {

    @Test
    public void testCarCreation() {
        Car car = new Car("Toyota", "Red", 2020);
        assertNotNull(car);
        assertEquals("Toyota", car.getModel());
        assertEquals("Red", car.getColor());
        assertEquals(2020, car.getYear());
    }

    @Test
    public void testSettersAndGetters() {
        Car car = new Car("Toyota", "Red", 2020);
        car.setModel("Honda");
        car.setColor("Blue");
        car.setYear(2021);

        assertEquals("Honda", car.getModel());
        assertEquals("Blue", car.getColor());
        assertEquals(2021, car.getYear());
    }
}
