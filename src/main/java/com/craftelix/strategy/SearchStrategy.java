package com.craftelix.strategy;

import com.craftelix.objects.Entity;
import com.craftelix.world.Cell;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface SearchStrategy {

    List<Cell> getPathToTargetCell(Map<Cell, Entity> map, Cell startCell, Set<Cell> targetCells);
}
