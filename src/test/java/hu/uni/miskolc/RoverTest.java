package hu.uni.miskolc;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RoverTest {
    // Egy alapértelmezett bolygó az összes teszthez
    // Legyen mondjuk 100x100 méretű
    private final Planet defaultPlanet = new Planet(100, 100);
    // 1. Teszt: "test_rover_can_be_initialized"
    // Ez a "RED" fázis
    @Test
    void testRoverCanBeInitialized() {
        Rover rover = new Rover(0, 0, Direction.N, defaultPlanet);
        assertEquals(0, rover.getX());
        assertEquals(0, rover.getY());
        assertEquals(Direction.N, rover.getDirection());
    }
    // 2. Teszt: "test_rover_can_turn_right_from_north"
    @Test
    void testRoverCanTurnRightFromNorth() {
        Rover rover = new Rover(0, 0, Direction.N, defaultPlanet); // ENUM
        rover.execute("r");
        assertEquals(Direction.E, rover.getDirection()); // ENUM
    }
    // 3. Teszt: "test_rover_can_turn_right_from_east"
    @Test
    void testRoverCanTurnRightFromEast() {
        Rover rover = new Rover(0, 0, Direction.E, defaultPlanet); // ENUM
        rover.execute("r");
        assertEquals(Direction.S, rover.getDirection()); // ENUM
    }
    // 4. Teszt: "test_rover_can_turn_right_from_south"
    @Test
    void testRoverCanTurnRightFromSouth() {
        Rover rover = new Rover(0, 0, Direction.S, defaultPlanet); // ENUM
        rover.execute("r");
        assertEquals(Direction.W, rover.getDirection()); // ENUM
    }
    // 5. Teszt: "test_rover_can_turn_right_from_west"
    @Test
    void testRoverCanTurnRightFromWest() {
        Rover rover = new Rover(0, 0, Direction.W,defaultPlanet); // ENUM
        rover.execute("r");
        assertEquals(Direction.N, rover.getDirection()); // ENUM
    }
    // 6. Teszt: "test_rover_can_turn_left_from_north"
    @Test
    void testRoverCanTurnLeftFromNorth() {
        // Adott egy Rover, ami északra néz
        Rover rover = new Rover(0, 0, Direction.N,defaultPlanet);

        // Amikor kap egy 'l' (left) parancsot
        // Ez piros lesz, mert az execute még nem kezeli az 'l'-t
        rover.execute("l");

        // Akkor nyugatra ('W') kell néznie
        assertEquals(Direction.W, rover.getDirection());
    }
    // 7. Teszt: "test_rover_can_move_forward_facing_north"
    @Test
    void testRoverCanMoveForwardFacingNorth() {
        // Adott egy Rover (0,0)-n, ami északra néz
        Rover rover = new Rover(0, 0, Direction.N,defaultPlanet);

        // Amikor kap egy 'f' (forward) parancsot
        // Ez piros lesz, mert az execute még nem kezeli az 'f'-et
        rover.execute("f");

        // Akkor a pozíciójának (0,1)-re kell változnia
        assertEquals(0, rover.getX());
        assertEquals(1, rover.getY());
        // Az iránya nem változik
        assertEquals(Direction.N, rover.getDirection());
    }
    // 8. Teszt: "test_rover_can_move_forward_facing_east"
    @Test
    void testRoverCanMoveForwardFacingEast() {
        // Adott egy Rover (0,0)-n, ami keletre néz
        Rover rover = new Rover(0, 0, Direction.E,defaultPlanet);

        // Amikor kap egy 'f' (forward) parancsot
        rover.execute("f");

        // Akkor a pozíciójának (1,0)-ra kell változnia
        assertEquals(1, rover.getX()); // X nő eggyel
        assertEquals(0, rover.getY());
        // Az iránya nem változik
        assertEquals(Direction.E, rover.getDirection());
    }
    // 9. Teszt: "test_rover_can_move_forward_facing_south"
    @Test
    void testRoverCanMoveForwardFacingSouth() {
        // Adott egy Rover (0,0)-n, ami délre néz
        Rover rover = new Rover(0, 0, Direction.S,defaultPlanet);

        // Amikor kap egy 'f' (forward) parancsot
        rover.execute("f");

        // Akkor a pozíciójának (0,-1)-re kell változnia
        assertEquals(0, rover.getX());
        assertEquals(-1, rover.getY()); // Y csökken eggyel
        // Az iránya nem változik
        assertEquals(Direction.S, rover.getDirection());
    }
    // 10. Teszt: "test_rover_can_move_forward_facing_west"
    @Test
    void testRoverCanMoveForwardFacingWest() {
        // Adott egy Rover (0,0)-n, ami nyugatra néz
        Rover rover = new Rover(0, 0, Direction.W,defaultPlanet);

        // Amikor kap egy 'f' (forward) parancsot
        rover.execute("f");

        // Akkor a pozíciójának (-1,0)-ra kell változnia
        assertEquals(-1, rover.getX()); // X csökken eggyel
        assertEquals(0, rover.getY());
        // Az iránya nem változik
        assertEquals(Direction.W, rover.getDirection());
    }
    // 11. Teszt: "test_rover_can_move_backward_facing_north"
    @Test
    void testRoverCanMoveBackwardFacingNorth() {
        // Adott egy Rover (0,0)-n, ami északra néz
        Rover rover = new Rover(0, 0, Direction.N,defaultPlanet);

        // Amikor kap egy 'b' (backward) parancsot
        // Ez piros lesz, mert az execute még nem kezeli a 'b'-t
        rover.execute("b");

        // Akkor a pozíciójának (0,-1)-re kell változnia (azaz délre lép)
        assertEquals(0, rover.getX());
        assertEquals(-1, rover.getY());
        // Az iránya nem változik
        assertEquals(Direction.N, rover.getDirection());
    }

}
