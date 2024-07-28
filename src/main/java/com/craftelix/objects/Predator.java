package com.craftelix.objects;

import com.craftelix.strategy.SearchStrategy;
import com.craftelix.world.Cell;
import com.craftelix.world.World;

public class Predator extends Creature {

    public final int attack;

    public Predator(Cell cell, World world, int health, int speed, int attack, SearchStrategy strategy) {
        super(cell, world, health, speed, strategy);
        this.attack = attack;
    }

    @Override
    public void makeMove() {
        moveTo(Herbivore.class);
    }

    @Override
    public void handleTargetInteraction(Cell targetCell) {
        Herbivore herbivore = (Herbivore) world.getEntity(targetCell);
        hitEnemy(herbivore);
        if (herbivore.health == 0) {
            System.out.println(this + " move to " + targetCell);
            world.removeEntity(targetCell);
            world.moveCreatureTo(targetCell, this);
        }
    }

    private void hitEnemy(Herbivore herbivore) {
        System.out.println(this + " hit " + herbivore);
        herbivore.health = this.attack > herbivore.health ? 0 : herbivore.health - this.attack;
        System.out.println("Herbivore health is " + herbivore.health);
    }

    @Override
    public String toString() {
        return "Predator{"
                + "Cell={"
                + "row=" + cell.row
                + ", col=" + cell.col
                + '}'
                + ", health=" + health
                + ", speed=" + speed
                + ", attack=" + attack
                + '}';
    }
}
