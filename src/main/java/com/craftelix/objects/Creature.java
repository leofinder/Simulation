package com.craftelix.objects;

import com.craftelix.map.Cell;

import java.util.HashMap;
import java.util.Map;

public abstract class Creature extends Entity {

    private Cell cell;
    private Map<Cell, Entity> field;
    private int lives;
    private int speed;

    public Creature(Cell cell, Map<Cell, Entity> field, int lives, int speed) {
        this.cell = cell;
        this.field = field;
        this.lives = lives;
        this.speed = speed;

    }

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public int getSpeed() {
        return speed;
    }

    public int getLives() {
        return lives;
    }

    public abstract void makeMove();


}
