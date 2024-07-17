package com.craftelix.objects;

import com.craftelix.map.Cell;

import java.util.Map;

public class Herbivore extends Creature {

    public Herbivore(Cell cell, Map<Cell, Entity> field, int lives, int speed) {
        super(cell, field, lives, speed);
    }

    @Override
    public void makeMove() {

    }

    @Override
    public String toString() {
        return "\uD83D\uDC07";
    }
}
