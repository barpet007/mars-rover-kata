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


    public void execute(String commands) { // Átneveztem a paramétert 'commands'-ra

        // Végigmegyünk a parancssorozat minden egyes karakterén
        for (char command : commands.toCharArray()) {

            // Az 'if-else if' lánc most már a 'char'-t vizsgálja
            if (command == 'r') {
                this.direction = this.direction.turnRight();

            } else if (command == 'l') {
                this.direction = this.direction.turnLeft();

            } else if (command == 'f') {
                int dx = this.direction.getDeltaX();
                int dy = this.direction.getDeltaY();

                this.x = (this.x + dx + planet.getWidth()) % planet.getWidth();
                this.y = (this.y + dy + planet.getHeight()) % planet.getHeight();

            } else if (command == 'b') {
                int dx = this.direction.getDeltaX();
                int dy = this.direction.getDeltaY();

                this.x = (this.x - dx + planet.getWidth()) % planet.getWidth();
                this.y = (this.y - dy + planet.getHeight()) % planet.getHeight();
            }
            // Ha ismeretlen a parancs (pl. 'x'), egyszerűen kihagyjuk
        }
    }
}
