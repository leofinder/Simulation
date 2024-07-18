package com.craftelix.objects;

import com.craftelix.map.Cell;

import java.util.Map;

public class Predator extends Creature {

    private int attack;

    public Predator(Cell cell, Map<Cell, Entity> field, int lives, int speed, int attack) {
        super(cell, field, lives, speed);
        this.attack = attack;
    }

    @Override
    public void makeMove() {

    }

    @Override
    public String toString() {
        return "🐺";
    }
}
