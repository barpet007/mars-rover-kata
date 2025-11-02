package hu.uni.miskolc;

import java.util.Set; // EZT IMPORTÁLNI KELL

public class Planet {
    private final int width;
    private final int height;
    // EZ AZ ÚJ MEZŐ:
    private final Set<Position> obstacles;

    /**
     * Konstruktor, ami fogadja az akadályok listáját is.
     */
    public Planet(int width, int height, Set<Position> obstacles) {
        this.width = width;
        this.height = height;
        this.obstacles = obstacles;
    }

    /**
     * Egy kényelmi konstruktor akadálymentes bolygókhoz.
     */
    public Planet(int width, int height) {
        // Áthívunk a másik konstruktorba egy üres akadálylistával
        this(width, height, Set.of());
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    /**
     * Megmondja, hogy az adott pozíción van-e akadály.
     */
    public boolean hasObstacleAt(Position position) {
        return this.obstacles.contains(position);
    }
}
