package hu.uni.miskolc;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RoverTest {

    // 1. Teszt: "test_rover_can_be_initialized"
    // Ez a "RED" fázis
    @Test
    void testRoverCanBeInitialized() {
        Rover rover = new Rover(0, 0, Direction.N);
        assertEquals(0, rover.getX());
        assertEquals(0, rover.getY());
        assertEquals(Direction.N, rover.getDirection());
    }
    // 2. Teszt: "test_rover_can_turn_right_from_north"
    @Test
    void testRoverCanTurnRightFromNorth() {
        Rover rover = new Rover(0, 0, Direction.N); // ENUM
        rover.execute("r");
        assertEquals(Direction.E, rover.getDirection()); // ENUM
    }
    // 3. Teszt: "test_rover_can_turn_right_from_east"
    @Test
    void testRoverCanTurnRightFromEast() {
        Rover rover = new Rover(0, 0, Direction.E); // ENUM
        rover.execute("r");
        assertEquals(Direction.S, rover.getDirection()); // ENUM
    }
    // 4. Teszt: "test_rover_can_turn_right_from_south"
    @Test
    void testRoverCanTurnRightFromSouth() {
        Rover rover = new Rover(0, 0, Direction.S); // ENUM
        rover.execute("r");
        assertEquals(Direction.W, rover.getDirection()); // ENUM
    }
    // 5. Teszt: "test_rover_can_turn_right_from_west"
    @Test
    void testRoverCanTurnRightFromWest() {
        Rover rover = new Rover(0, 0, Direction.W); // ENUM
        rover.execute("r");
        assertEquals(Direction.N, rover.getDirection()); // ENUM
    }

}
