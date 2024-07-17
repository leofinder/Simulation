package com.craftelix.objects;

public class Predator extends Creature {

    private int attackPower;

    public Predator(int speed, int lives, int attackPower) {
        super(speed, lives);
        this.attackPower = attackPower;
    }

    @Override
    public void makeMove() {

    }
}
