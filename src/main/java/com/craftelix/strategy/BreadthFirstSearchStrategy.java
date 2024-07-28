package com.craftelix.strategy;

import com.craftelix.world.Cell;
import com.craftelix.world.World;

import java.util.*;

public class BreadthFirstSearchStrategy implements SearchStrategy {

    @Override
    public List<Cell> getPathToTargetCell(World world, Cell startCell, Set<Cell> targetCells) {
        TreeList<Cell> treeList = getTreeList(world, startCell, targetCells);
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

    private TreeList<Cell> getTreeList(World world, Cell startCell, Set<Cell> targetCells) {
        Queue<Cell> queue = new LinkedList<>();
        Set<Cell> visited = new HashSet<>();
        queue.add(startCell);
        visited.add(startCell);
        TreeList<Cell> treeList = new TreeList<>(startCell);
        boolean targetFound = false;

        while (!queue.isEmpty() && !targetFound) {
            Cell cell = queue.remove();
            for (Cell neighborCell : getNeighborCells(cell, world)) {
                if (world.isCellEmpty(neighborCell) || targetCells.contains(neighborCell)) {
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

    private Set<Cell> getNeighborCells(Cell cell, World world) {
        Set<Cell> neighborCells = new HashSet<>();
        if (cell.row > 0) {
            neighborCells.add(new Cell(cell.row - 1, cell.col));
        }
        if (cell.row + 1 < world.rows) {
            neighborCells.add(new Cell(cell.row + 1, cell.col));
        }
        if (cell.col > 0) {
            neighborCells.add(new Cell(cell.row, cell.col - 1));
        }
        if (cell.col + 1 < world.cols) {
            neighborCells.add(new Cell(cell.row, cell.col + 1));
        }
        return neighborCells;
    }
}
