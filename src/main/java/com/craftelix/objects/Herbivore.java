package com.craftelix.objects;

import com.craftelix.strategy.SearchStrategy;
import com.craftelix.strategy.SearchStrategyUtils;
import com.craftelix.world.Cell;

import java.util.*;

public class Herbivore extends Creature {

    public Herbivore(Cell cell, Map<Cell, Entity> map, int health, int speed, SearchStrategy strategy) {
        super(cell, map, health, speed, strategy);
    }

    @Override
    public void makeMove() {
        Set<Cell> targetCells = SearchStrategyUtils.getTargetCells(map, Grass.class);
        List<Cell> path = strategy.getPathToTargetCell(map, cell, targetCells);
        Cell lastCell = path.get(path.size() - 1);
        if (targetCells.contains(lastCell) && path.size() == 2) {
            System.out.println("Path: " + path.size());
            useResourceAt(lastCell);
            super.moveTo(lastCell);
        } else {
            super.moveTo(lastCell, path, targetCells);
        }
    }

    private void useResourceAt(Cell targetCell) {
        System.out.println(this + " uses " + targetCell);
        map.put(targetCell, null);
    }

    @Override
    public String toString() {
        return "Herbivore{"
                + "cell={" + cell.getRow() + "," + cell.getCol() + '}'
                + ", health=" + health
                + ", speed=" + speed
                + '}';
    }
}
