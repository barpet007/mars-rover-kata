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
}
