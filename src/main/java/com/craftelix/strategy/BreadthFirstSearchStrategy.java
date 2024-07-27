package com.craftelix.strategy;

import com.craftelix.objects.Entity;
import com.craftelix.world.Cell;

import java.util.*;

public class BreadthFirstSearchStrategy implements SearchStrategy {

    @Override
    public List<Cell> getPathToTargetCell(Map<Cell, Entity> map, Cell startCell, Set<Cell> targetCells) {
        TreeList<Cell> treeList = getTreeList(map, startCell, targetCells);
        List<Cell> lastNodeValues = treeList.getLastNodeValues();
        List<Cell> path = new ArrayList<>();
        for (Cell cell : lastNodeValues) {
            if (targetCells.contains(cell)) {
                path = treeList.getPathTo(cell);
                if (!path.isEmpty()) {
                    break;
                }
            }
        }
        if (path.isEmpty() && !lastNodeValues.isEmpty()) {
            path = treeList.getPathTo(lastNodeValues.get(0));
        }
        return path;
    }

    public static TreeList<Cell> getTreeList(Map<Cell, Entity> map, Cell startCell, Set<Cell> targetCells) {
        Queue<Cell> queue = new LinkedList<>();
        Set<Cell> visited = new HashSet<>();
        queue.add(startCell);
        visited.add(startCell);
        TreeList<Cell> treeList = new TreeList<>(startCell);
        boolean targetFound = false;

        while (!queue.isEmpty() && !targetFound) {
            Cell cell = queue.remove();
            for (Cell neighborCell : SearchStrategyUtils.getNeighborCells(cell)) {
                if (!map.containsKey(neighborCell)) {
                    continue;
                }
                if (map.get(neighborCell) == null || targetCells.contains(neighborCell)) {
                    if (!visited.contains(neighborCell)) {
                        treeList.add(cell, neighborCell);
                        if (targetCells.contains(neighborCell)) {
                            targetFound = true;
                        }
                        queue.add(neighborCell);
                        visited.add(neighborCell);
                    }
                }
            }
        }
        return treeList;
    }

}
