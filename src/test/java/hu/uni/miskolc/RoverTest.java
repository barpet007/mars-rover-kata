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
        String status = rover.execute("r");
        assertEquals(Direction.E, rover.getDirection()); // ENUM
        assertEquals("OK", status);
    }
    // 3. Teszt: "test_rover_can_turn_right_from_east"
    @Test
    void testRoverCanTurnRightFromEast() {
        Rover rover = new Rover(0, 0, Direction.E, defaultPlanet); // ENUM
        String status = rover.execute("r");
        assertEquals(Direction.S, rover.getDirection()); // ENUM
        assertEquals("OK", status);
    }
    // 4. Teszt: "test_rover_can_turn_right_from_south"
    @Test
    void testRoverCanTurnRightFromSouth() {
        Rover rover = new Rover(0, 0, Direction.S, defaultPlanet); // ENUM
        String status = rover.execute("r");
        assertEquals(Direction.W, rover.getDirection());// ENUM
        assertEquals("OK", status);
    }
    // 5. Teszt: "test_rover_can_turn_right_from_west"
    @Test
    void testRoverCanTurnRightFromWest() {
        Rover rover = new Rover(0, 0, Direction.W,defaultPlanet); // ENUM
        String status = rover.execute("r");
        assertEquals(Direction.N, rover.getDirection()); // ENUM
        assertEquals("OK", status);
    }
    // 6. Teszt: "test_rover_can_turn_left_from_north"
    @Test
    void testRoverCanTurnLeftFromNorth() {
        // Adott egy Rover, ami északra néz
        Rover rover = new Rover(0, 0, Direction.N,defaultPlanet);

        // Amikor kap egy 'l' (left) parancsot
        // Ez piros lesz, mert az execute még nem kezeli az 'l'-t
        String status = rover.execute("l");


        // Akkor nyugatra ('W') kell néznie
        assertEquals(Direction.W, rover.getDirection());
        assertEquals("OK", status);
    }
    // 7. Teszt: "test_rover_can_move_forward_facing_north"
    @Test
    void testRoverCanMoveForwardFacingNorth() {
        // Adott egy Rover (0,0)-n, ami északra néz
        Rover rover = new Rover(0, 0, Direction.N,defaultPlanet);

        // Amikor kap egy 'f' (forward) parancsot
        // Ez piros lesz, mert az execute még nem kezeli az 'f'-et
        String status = rover.execute("f");

        // Akkor a pozíciójának (0,1)-re kell változnia
        assertEquals(0, rover.getX());
        assertEquals(1, rover.getY());
        // Az iránya nem változik
        assertEquals(Direction.N, rover.getDirection());
        assertEquals("OK", status);
    }
    // 8. Teszt: "test_rover_can_move_forward_facing_east"
    @Test
    void testRoverCanMoveForwardFacingEast() {
        // Adott egy Rover (0,0)-n, ami keletre néz
        Rover rover = new Rover(0, 0, Direction.E,defaultPlanet);

        // Amikor kap egy 'f' (forward) parancsot
        String status = rover.execute("f");

        // Akkor a pozíciójának (1,0)-ra kell változnia
        assertEquals(1, rover.getX()); // X nő eggyel
        assertEquals(0, rover.getY());
        // Az iránya nem változik
        assertEquals(Direction.E, rover.getDirection());
        assertEquals("OK", status);
    }
    // 9. Teszt: "test_rover_can_move_forward_facing_south"
    @Test
    void testRoverCanMoveForwardFacingSouth() {
        // Adott egy Rover (0,0)-n, ami délre néz
        Rover rover = new Rover(0, 0, Direction.S,defaultPlanet);

        // Amikor kap egy 'f' (forward) parancsot
        String status = rover.execute("f");

        // Akkor a pozíciójának (0,-1)-re kell változnia
        assertEquals(0, rover.getX());
        assertEquals(defaultPlanet.getHeight() - 1, rover.getY()); // Y csökken eggyel
        // Az iránya nem változik
        assertEquals(Direction.S, rover.getDirection());
        assertEquals("OK", status);
    }
    // 10. Teszt: "test_rover_can_move_forward_facing_west"
    @Test
    void testRoverCanMoveForwardFacingWest() {
        // Adott egy Rover (0,0)-n, ami nyugatra néz
        Rover rover = new Rover(0, 0, Direction.W,defaultPlanet);

        // Amikor kap egy 'f' (forward) parancsot
        String status = rover.execute("f");

        // Akkor a pozíciójának (-1,0)-ra kell változnia
        assertEquals(defaultPlanet.getWidth() - 1, rover.getX()); // X csökken eggyel
        assertEquals(0, rover.getY());
        // Az iránya nem változik
        assertEquals(Direction.W, rover.getDirection());
        assertEquals("OK", status);
    }
    // 11. Teszt: "test_rover_can_move_backward_facing_north"
    @Test
    void testRoverCanMoveBackwardFacingNorth() {
        // Adott egy Rover (0,0)-n, ami északra néz
        Rover rover = new Rover(0, 0, Direction.N,defaultPlanet);

        // Amikor kap egy 'b' (backward) parancsot
        // Ez piros lesz, mert az execute még nem kezeli a 'b'-t
        String status = rover.execute("b");

        // Akkor a pozíciójának (0,-1)-re kell változnia (azaz délre lép)
        assertEquals(0, rover.getX());
        assertEquals(defaultPlanet.getHeight() - 1, rover.getY());
        // Az iránya nem változik
        assertEquals(Direction.N, rover.getDirection());
        assertEquals("OK", status);
    }
    // 12. Teszt: "test_rover_wraps_at_north_pole"
    @Test
    void testRoverWrapsAtNorthPole() {
        // Adott egy 10x10-es bolygó
        Planet smallPlanet = new Planet(10, 10);

        // A Rover a "legészakibb" ponton áll (x=0, y=9)
        // (Mivel a bolygó 10 magas, a koordináták 0-tól 9-ig mennek)
        int startX = 0;
        int startY = smallPlanet.getHeight() - 1; // Ez 9 lesz

        Rover rover = new Rover(startX, startY, Direction.N, smallPlanet);

        // Amikor kap egy 'f' (forward) parancsot
        String status = rover.execute("f");


        // Akkor át kell tekerednie a "déli sarokra" (y=0)
        assertEquals(0, rover.getX());
        assertEquals(0, rover.getY()); // A várt eredmény a 0, nem a 10!
    }
    // 13. Teszt: "test_rover_can_execute_multiple_commands"
    @Test
    void testRoverCanExecuteMultipleCommands() {
        // Adott egy Rover (0,0)-n, ami északra néz
        Rover rover = new Rover(0, 0, Direction.N, defaultPlanet);

        // Amikor kap egy parancssorozatot: "rff"
        // (Jobbra, Előre, Előre)
        String status = rover.execute("rff");

        // Akkor a végeredménynek (2,0) kell lennie, Kelet felé nézve
        // N(0,0) -> 'r' -> E(0,0) -> 'f' -> E(1,0) -> 'f' -> E(2,0)
        assertEquals(2, rover.getX());
        assertEquals(0, rover.getY());
        assertEquals(Direction.E, rover.getDirection());
        assertEquals("OK", status);
    }

}
