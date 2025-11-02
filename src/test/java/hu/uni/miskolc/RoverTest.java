package hu.uni.miskolc;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RoverTest {

    // 1. Teszt: "test_rover_can_be_initialized"
    // Ez a "RED" fázis
    @Test
    void testRoverCanBeInitialized() {
        // Amikor létrehozunk egy Rovert egy adott pozícióval és iránnyal
        // Ez a sor piros lesz, mert a 'Rover' osztály még nem létezik
        Rover rover = new Rover(0, 0, 'N');

        // Akkor a pozíciója és iránya a megadott érték
        assertEquals(0, rover.getX());
        assertEquals(0, rover.getY());
        assertEquals('N', rover.getDirection());
    }
    // 2. Teszt: "test_rover_can_turn_right_from_north"
    @Test
    void testRoverCanTurnRightFromNorth() {
        // Adott egy Rover, ami északra néz
        Rover rover = new Rover(0, 0, 'N');

        // Amikor kap egy 'r' (right) parancsot
        // Ez piros lesz, mert az 'execute' metódus még nem létezik
        rover.execute("r");

        // Akkor keletre ('E') kell néznie
        assertEquals('E', rover.getDirection());
    }
    // 3. Teszt: "test_rover_can_turn_right_from_east"
    @Test
    void testRoverCanTurnRightFromEast() {
        // Adott egy Rover, ami keletre néz
        Rover rover = new Rover(0, 0, 'E');

        // Amikor kap egy 'r' (right) parancsot
        rover.execute("r");

        // Akkor délre ('S') kell néznie
        assertEquals('S', rover.getDirection());
    }
    // 4. Teszt: "test_rover_can_turn_right_from_south"
    @Test
    void testRoverCanTurnRightFromSouth() {
        // Adott egy Rover, ami délre néz
        Rover rover = new Rover(0, 0, 'S');

        // Amikor kap egy 'r' (right) parancsot
        rover.execute("r");

        // Akkor nyugatra ('W') kell néznie
        assertEquals('W', rover.getDirection());
    }
}
