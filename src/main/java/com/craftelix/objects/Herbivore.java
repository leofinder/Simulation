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
        Set<Cell> targetCells = SearchStrategyUtils.getTargetCells(map, Arrays.asList(Grass.class));
        List<Cell> neighborTargetCells = SearchStrategyUtils.getNeighborTargetCells(cell, targetCells);
        if (!neighborTargetCells.isEmpty()) {
            Random random = new Random();
            Cell targetCell = neighborTargetCells.get(random.nextInt(neighborTargetCells.size()));
            useResourceAt(targetCell);
            moveTo(targetCell);
        } else {
            List<Cell> path = strategy.getPathToTargetCell(map, cell, targetCells);
            if (path.size() == 2) {
                Cell targetCell = path.get(1);
                useResourceAt(targetCell);
                moveTo(targetCell);
            } else if (path.size() > 2) {
                Cell targetCell = speed > path.size() - 1 ? path.get(path.size() - 2) : path.get(speed);
                moveTo(targetCell);
            }
        }
    }

    private void moveTo(Cell targetCell) {
        System.out.println("Herbivore " + this + " moved to " + targetCell);
        map.put(cell, null);
        map.put(targetCell, this);
        cell = targetCell;

    }

    private void useResourceAt(Cell targetCell) {
        System.out.println("Herbivore " + this + " uses " + targetCell);
        Entity value = map.put(targetCell, null);
        value = null;

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
