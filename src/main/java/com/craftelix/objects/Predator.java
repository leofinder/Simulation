package com.craftelix.objects;

import com.craftelix.strategy.SearchStrategy;
import com.craftelix.strategy.SearchStrategyUtils;
import com.craftelix.world.Cell;

import java.util.*;

public class Predator extends Creature {

    private int attack;

    public Predator(Cell cell, Map<Cell, Entity> map, int health, int speed, int attack, SearchStrategy strategy) {
        super(cell, map, health, speed, strategy);
        this.attack = attack;
    }

    @Override
    public void makeMove() {
        Set<Cell> targetCells = SearchStrategyUtils.getTargetCells(map, Arrays.asList(Herbivore.class));
        List<Cell> neighborTargetCells = SearchStrategyUtils.getNeighborTargetCells(cell, targetCells);
        if (!neighborTargetCells.isEmpty()) {
            Random random = new Random();
            Cell targetCell = neighborTargetCells.get(random.nextInt(neighborTargetCells.size()));
            hitEnemyAt(targetCell);
            if (map.get(targetCell) == null) {
                moveTo(targetCell);
            }
        } else {
            List<Cell> path = strategy.getPathToTargetCell(map, cell, targetCells);
            if (path.size() == 2) {
                Cell targetCell = path.get(1);
                hitEnemyAt(targetCell);
                if (map.get(targetCell) == null) {
                    moveTo(targetCell);
                }
            } else if (path.size() > 2) {
                Cell targetCell = speed > path.size() - 1 ? path.get(path.size() - 2) : path.get(speed);
                moveTo(targetCell);
            }
        }
    }

    private void moveTo(Cell targetCell) {
        map.put(cell, null);
        map.put(targetCell, this);
        cell = targetCell;
    }

    private void hitEnemyAt(Cell targetCell) {
        Herbivore herbivore = (Herbivore) map.get(targetCell);
        herbivore.health  = this.attack > herbivore.health ? 0 : herbivore.health - this.attack;
        if (herbivore.health == 0) {
            herbivore = null;
            map.put(targetCell, null);
        }
    }

    @Override
    public String toString() {
        return "Predator{"
                + "cell={" + cell.getRow() + "," + cell.getCol() + '}'
                + ", health=" + health
                + ", speed=" + speed
                + ", attack=" + attack
                + '}';
    }
}
