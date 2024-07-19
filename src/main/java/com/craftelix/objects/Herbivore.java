package com.craftelix.objects;

import com.craftelix.map.Cell;

import java.util.Map;

public class Herbivore extends Creature {

    public Herbivore(Cell cell, Map<Cell, Entity> map, int health, int speed) {
        super(cell, map, health, speed);
    }

    @Override
    public void makeMove() {

    }

    @Override
    public String toString() {
        return "Herbivore{"
                + "cell={" + cell.getX() + "," + cell.getY() + '}'
                + ", health=" + health
                + ", speed=" + speed
                + '}';
    }
}
