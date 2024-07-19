package com.craftelix.objects;

import com.craftelix.map.Cell;

import java.util.HashMap;
import java.util.Map;

public abstract class Creature extends Entity {

    protected Cell cell;
    protected Map<Cell, Entity> map;
    protected int health;
    protected int speed;

    public Creature(Cell cell, Map<Cell, Entity> map, int health, int speed) {
        this.cell = cell;
        this.map = map;
        this.health = health;
        this.speed = speed;

    }

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public Map<Cell, Entity> getMap() {
        return map;
    }

    public int getHealth() {
        return health;
    }

    public int getSpeed() {
        return speed;
    }

    public abstract void makeMove();
}
