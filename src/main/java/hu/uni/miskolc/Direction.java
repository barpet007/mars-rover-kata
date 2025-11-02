package hu.uni.miskolc;

public enum Direction {
    // 1. Bővítsük az enumokat, hogy tárolják a deltàkat
    N(0, 1),
    E(1, 0),
    S(0, -1),
    W(-1, 0);

    // 2. Adjunk hozzá mezőket a deltàk tárolásához
    private final int deltaX;
    private final int deltaY;

    // 3. Hozzunk létre egy konstruktort az enumhoz
    Direction(int deltaX, int deltaY) {
        this.deltaX = deltaX;
        this.deltaY = deltaY;
    }

    // 4. Hozzunk létre gettereket, amiket a Rover használni fog
    public int getDeltaX() {
        return deltaX;
    }

    public int getDeltaY() {
        return deltaY;
    }

    // --- A régi kódunk (forgás) változatlan ---

    /**
     * Visszaadja a következő irányt, ha jobbra fordulunk.
     */
    public Direction turnRight() {
        switch (this) {
            case N: return E;
            case E: return S;
            case S: return W;
            case W: return N;
            default: throw new IllegalStateException("Ismeretlen irány");
        }
    }

    /**
     * Visszaadja a következő irányt, ha balra fordulunk.
     */
    public Direction turnLeft() {
        switch (this) {
            case N: return W;
            case W: return S;
            case S: return E;
            case E: return N;
            default: throw new IllegalStateException("Ismeretlen irány");
        }
    }
}
