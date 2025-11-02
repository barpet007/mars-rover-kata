package hu.uni.miskolc;

public class Rover {

    private int x;
    private int y;
    private Direction direction; // MÓDOSÍTVA

    // Konstruktor, ami beállítja a kezdőértékeket
    public Rover(int x, int y, Direction direction) { // MÓDOSÍTVA
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    // Getterek, amiket a teszt hív
    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public Direction getDirection() { // MÓDOSÍTVA
        return this.direction;
    }

    public void execute(String command) {
        // MÓDOSÍTVA: A teljes if-else lánc helyett
        if (command.equals("r")) {
            this.direction = this.direction.turnRight();
        }
    }
}