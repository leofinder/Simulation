package com.craftelix.objects;

import com.craftelix.strategy.SearchStrategy;
import com.craftelix.world.Cell;

import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class Creature extends Entity {

    protected Cell cell;
    protected Map<Cell, Entity> map;
    protected int health;
    protected int speed;
    protected SearchStrategy strategy;

    public Creature(Cell cell, Map<Cell, Entity> map, int health, int speed, SearchStrategy strategy) {
        this.cell = cell;
        this.map = map;
        this.health = health;
        this.speed = speed;
        this.strategy = strategy;
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

    public void moveTo(Cell targetCell) {
        System.out.println(this + " moved to " + targetCell);
        map.put(cell, null);
        map.put(targetCell, this);
        cell = targetCell;
    }

    public void moveTo(Cell lastCell, List<Cell> path, Set<Cell> targetCells) {
        int cellsCount = targetCells.contains(lastCell) ? path.size() - 1 : path.size();
        Cell targetCell = speed > cellsCount ? path.get(cellsCount - 1) : path.get(speed - 1);
        System.out.println("Path: " + (speed > path.size() ? path.size() - 1 : speed));
        moveTo(targetCell);
    }

    public abstract void makeMove();
}
