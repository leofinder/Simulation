package com.craftelix.strategy;

import com.craftelix.world.Cell;
import com.craftelix.world.World;

import java.util.List;
import java.util.Set;

public interface SearchStrategy {

    List<Cell> getPathToTargetCell(World world, Cell startCell, Set<Cell> targetCells);
}
