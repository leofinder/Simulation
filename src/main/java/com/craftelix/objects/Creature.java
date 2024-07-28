package com.craftelix.objects;

import com.craftelix.strategy.SearchStrategy;
import com.craftelix.world.Cell;
import com.craftelix.world.World;

import java.util.List;
import java.util.Set;

public abstract class Creature extends Entity {

    protected Cell cell;
    public final World world;
    protected int health;
    public final int speed;
    public final SearchStrategy strategy;

    public Creature(Cell cell, World world, int health, int speed, SearchStrategy strategy) {
        this.cell = cell;
        this.world = world;
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

    public int getHealth() {
        return health;
    }

    public abstract void makeMove();

    public abstract void handleTargetInteraction(Cell targetCell);

    public void moveTo(Class<? extends Entity> targetClass) {
        Set<Cell> targetCells = world.getCellsBy(targetClass);
        List<Cell> path = strategy.getPathToTargetCell(world, cell, targetCells);
        Cell lastCell = path.get(path.size() - 1);
        if (cell.equals(lastCell)) {
            System.out.println(this + " stay at " + cell);
        } else if (targetCells.contains(lastCell) && path.size() == 2) {
            handleTargetInteraction(lastCell);
        } else {
            int cellsCount = targetCells.contains(lastCell) ? path.size() - 1 : path.size();
            Cell targetCell = speed >= cellsCount ? path.get(cellsCount - 1) : path.get(speed);
            System.out.println(this + " move to " + targetCell);
            world.moveCreatureTo(targetCell, this);
        }
    }
}
