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

    public static Set<Cell> getTargetCells(Map<Cell, Entity> map, Class targetClass) {
        Set<Cell> targetCells = new HashSet<>();
        for (Map.Entry<Cell, Entity> entry : map.entrySet()) {
            if (entry.getValue() != null && entry.getValue().getClass().equals(targetClass)) {
                targetCells.add(entry.getKey());
            }
        }
        return targetCells;
    }
}
