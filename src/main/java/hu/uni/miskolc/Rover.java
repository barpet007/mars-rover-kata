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


    public void execute(String command) {
        if (command.equals("r")) {
            this.direction = this.direction.turnRight();
        } else if (command.equals("l")) {
            this.direction = this.direction.turnLeft();
        } else if (command.equals("f")) {
            int dx = this.direction.getDeltaX();
            int dy = this.direction.getDeltaY();

            this.x = (this.x + dx + planet.getWidth()) % planet.getWidth();
            this.y = (this.y + dy + planet.getHeight()) % planet.getHeight();
        } else if (command.equals("b")) {
            int dx = this.direction.getDeltaX();
            int dy = this.direction.getDeltaY();

            this.x = (this.x - dx + planet.getWidth()) % planet.getWidth();
            this.y = (this.y - dy + planet.getHeight()) % planet.getHeight();
        }

    }
}
