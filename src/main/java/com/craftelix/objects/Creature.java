package com.craftelix.objects;

public abstract class Creature extends Entity {

    private int speed;
    private int lives;

    public Creature(int speed, int lives) {
        this.speed = speed;
        this.lives = lives;
    }

    public abstract void makeMove();

}
