package com.craftelix.objects;

import com.craftelix.map.Cell;

import java.util.Map;

public class Predator extends Creature {

    private int attack;

    public Predator(Cell cell, Map<Cell, Entity> map, int health, int speed, int attack) {
        super(cell, map, health, speed);
        this.attack = attack;
    }

    @Override
    public void makeMove() {

    }

    @Override
    public String toString() {
        return "Predator{"
                + "cell={" + cell.getX() + "," + cell.getY() + '}'
                + ", health=" + health
                + ", speed=" + speed
                + ", attack=" + attack
                + '}';
    }
}
