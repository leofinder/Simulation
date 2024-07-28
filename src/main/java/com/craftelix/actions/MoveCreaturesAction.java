package com.craftelix.actions;

import com.craftelix.objects.Creature;
import com.craftelix.objects.Herbivore;
import com.craftelix.objects.Predator;
import com.craftelix.renderer.Renderer;
import com.craftelix.world.World;

public class MoveCreaturesAction implements Action {
    @Override
    public void perform(World world, Renderer renderer) {

        for (Herbivore herbivore : world.herbivore) {
            if (herbivore.getHealth() != 0) {
                handleCreatureMovement(herbivore, world, renderer);
            }
        }
        for (Predator predator : world.predators) {
            handleCreatureMovement(predator, world, renderer);
        }
        world.herbivore.removeIf(o -> o.getHealth() == 0);
    }

    private void handleCreatureMovement(Creature creature, World world, Renderer renderer) {
        creature.makeMove();
        renderer.render(world);
        sleep();
    }

    private void sleep() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
