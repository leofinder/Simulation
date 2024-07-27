package com.craftelix.objects;

import com.craftelix.strategy.SearchStrategy;
import com.craftelix.strategy.SearchStrategyUtils;
import com.craftelix.world.Cell;

import java.util.*;

public class Predator extends Creature {

    private final int attack;

    public Predator(Cell cell, Map<Cell, Entity> map, int health, int speed, int attack, SearchStrategy strategy) {
        super(cell, map, health, speed, strategy);
        this.attack = attack;
    }

    @Override
    public void makeMove() {
        Set<Cell> targetCells = SearchStrategyUtils.getTargetCells(map, Herbivore.class);
        List<Cell> path = strategy.getPathToTargetCell(map, cell, targetCells);
        Cell lastCell = path.get(path.size() - 1);
        if (targetCells.contains(lastCell) && path.size() == 2) {
            System.out.println("Path: " + path.size());
            hitEnemyAt(lastCell);
            if (map.get(lastCell) == null) {
                super.moveTo(lastCell);
            }
        } else {
            super.moveTo(lastCell, path, targetCells);
        }
    }

    private void hitEnemyAt(Cell targetCell) {
        System.out.println(this + " hit at " + map.get(targetCell));
        Herbivore herbivore = (Herbivore) map.get(targetCell);
        herbivore.health  = this.attack > herbivore.health ? 0 : herbivore.health - this.attack;
        if (herbivore.health == 0) {
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
