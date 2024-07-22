package com.craftelix.strategy;

import com.craftelix.objects.Entity;
import com.craftelix.world.Cell;

import java.util.*;

public class SearchStrategyUtils {
    private SearchStrategyUtils() {
        throw new UnsupportedOperationException("Utility class");
    }

    public static Set<Cell> getNeighborCells(Cell cell) {
        Set<Cell> neighborCells = new HashSet<>();
        neighborCells.add(new Cell(cell.getRow() - 1, cell.getCol()));
        neighborCells.add(new Cell(cell.getRow() + 1, cell.getCol()));
        neighborCells.add(new Cell(cell.getRow(), cell.getCol() - 1));
        neighborCells.add(new Cell(cell.getRow(), cell.getCol() + 1));
        return neighborCells;
    }

    public static Set<Cell> getTargetCells(Map<Cell, Entity> map, List<Class> targetClasses) {
        Set<Cell> targetCells = new HashSet<>();
        for (Map.Entry<Cell, Entity> entry : map.entrySet()) {
            if (entry.getValue() == null) {
                continue;
            }
            for (Class targetClass : targetClasses) {
                if (entry.getValue().getClass() == targetClass) {
                    targetCells.add(entry.getKey());
                }
            }
        }
        return targetCells;
    }

    public static List<Cell> getNeighborTargetCells(Cell currentCell, Set<Cell> targetCells) {
        List<Cell> neighborTargetCells = new ArrayList<>();
        Set<Cell> neighborCells = getNeighborCells(currentCell);
        for (Cell neighborCell : neighborCells) {
            if (targetCells.contains(neighborCell)) {
                neighborTargetCells.add(neighborCell);
            }
        }
        return neighborTargetCells;
    }
}
