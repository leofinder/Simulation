package com.craftelix.objects;

public class Herbivore extends Creature {

    public Herbivore(int speed, int lives) {
        super(speed, lives);
    }

    @Override
    public void makeMove() {

    }

    @Override
    public String toString() {
        return "\uD83D\uDC07";
    }
}
