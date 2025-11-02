package hu.uni.miskolc;

public class Rover {

    private int x;
    private int y;
    private Direction direction;
    private final Planet planet;


    public Rover(int x, int y, Direction direction, Planet planet) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.planet = planet; // EZ AZ ÚJ SOR
    }

    // Getterek, amiket a teszt hív
    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public Direction getDirection() {
        return this.direction;
    }


    public void execute(String commands) {
        for (char command : commands.toCharArray()) {
            switch (command) {
                case 'r':
                    this.direction = this.direction.turnRight();
                    break;
                case 'l':
                    this.direction = this.direction.turnLeft();
                    break;
                case 'f':
                    int dx_f = this.direction.getDeltaX();
                    int dy_f = this.direction.getDeltaY();
                    this.x = (this.x + dx_f + planet.getWidth()) % planet.getWidth();
                    this.y = (this.y + dy_f + planet.getHeight()) % planet.getHeight();
                    break;
                case 'b':
                    int dx_b = this.direction.getDeltaX();
                    int dy_b = this.direction.getDeltaY();
                    this.x = (this.x - dx_b + planet.getWidth()) % planet.getWidth();
                    this.y = (this.y - dy_b + planet.getHeight()) % planet.getHeight();
                    break;
                // Alapértelmezett (default) eset:
                // Ha ismeretlen a karakter, nem csinálunk semmit
            }
        }
    }
}
