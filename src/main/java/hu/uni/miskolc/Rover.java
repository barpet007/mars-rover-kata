package hu.uni.miskolc;

public class Rover {

    private int x;
    private int y;
    private char direction;

    // Konstruktor, ami beállítja a kezdőértékeket
    public Rover(int x, int y, char direction) {
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

    public char getDirection() {
        return this.direction;
    }
    // ... (a getter metódusok után)

    public void execute(String command) {
        if (command.equals("r")) {
            // Szigorúan csak annyi kód, hogy a teszt átmenjen:
            if (this.direction == 'N') {
                this.direction = 'E';
            }
        }
    }
}
