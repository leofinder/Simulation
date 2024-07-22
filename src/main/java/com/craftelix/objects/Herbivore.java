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
            Entity value = map.put(targetCell, this);
            value = null;
            cell = targetCell;
        } else {
            List<Cell> path = strategy.getPathToTargetCell(map, cell, targetCells);
            if (!path.isEmpty()) {
//                if (speed >= path.size()) {
//                    targetCell = path.get(path.size() - 2);
//                }
            }

        }

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
