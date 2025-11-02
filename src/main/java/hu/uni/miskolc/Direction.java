package hu.uni.miskolc;

public enum Direction {
    N, E, S, W; // A négy lehetséges irány

    /**
     * Visszaadja a következő irányt, ha jobbra fordulunk.
     */
    public Direction turnRight() {
        // A 'this' kulcsszó az aktuális enum értékre utal (pl. N)
        switch (this) {
            case N:
                return E; // Északról Keletre
            case E:
                return S; // Keletről Délre
            case S:
                return W; // Délről Nyugatra
            case W:
                return N; // Nyugatról Északra
            default:
                // Elvileg sosem juthat ide, de jó gyakorlat
                throw new IllegalStateException("Ismeretlen irány");
        }
    }

}
