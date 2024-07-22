package com.craftelix.objects;

import com.craftelix.strategy.SearchStrategy;
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
