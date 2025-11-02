package hu.uni.miskolc;

public class Rover {
    private Position position;
    private Direction direction;
    private final Planet planet;


    public Rover(int x, int y, Direction direction, Planet planet) {
        this.position = new Position(x, y);
        this.direction = direction;
        this.planet = planet; // EZ AZ ÚJ SOR
    }

    // Getterek, amiket a teszt hív
    public int getX() { return this.position.x();}


    public int getY() { return this.position.y();}

    public Direction getDirection() {
        return this.direction;
    }


    public String execute(String commands) {
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
                    // Először kiszámoljuk az új X-et és Y-t
                    int newX_f = (this.position.x() + dx_f + planet.getWidth()) % planet.getWidth();
                    int newY_f = (this.position.y() + dy_f + planet.getHeight()) % planet.getHeight();
                    // Majd létrehozunk egy ÚJ Position objektumot
                    this.position = new Position(newX_f, newY_f);
                    break;
                case 'b':
                    int dx_b = this.direction.getDeltaX();
                    int dy_b = this.direction.getDeltaY();
                    int newX_b = (this.position.x() - dx_b + planet.getWidth()) % planet.getWidth();
                    int newY_b = (this.position.y() - dy_b + planet.getHeight()) % planet.getHeight();

                    this.position = new Position(newX_b, newY_b);
                    break;
            }
        }
        return "OK";
    }
}
