package com.craftelix.objects;

import com.craftelix.strategy.SearchStrategy;
import com.craftelix.world.Cell;
import com.craftelix.world.World;

public class Herbivore extends Creature {

    public Herbivore(Cell cell, World world, int health, int speed, SearchStrategy strategy) {
        super(cell, world, health, speed, strategy);
    }

    @Override
    public void makeMove() {
        moveTo(Grass.class);
    }

    @Override
    public void handleTargetInteraction(Cell targetCell) {
        System.out.println(this + " eat grass at " + targetCell);
        System.out.println(this + " move to " + targetCell);
        world.removeEntity(targetCell);
        world.moveCreatureTo(targetCell, this);
    }

    @Override
    public String toString() {
        return "Herbivore{"
                + "Cell={"
                + "row=" + cell.row
                + ", col=" + cell.col
                + '}'
                + ", health=" + health
                + ", speed=" + speed
                + '}';
    }
}
