package com.craftelix.actions;

import com.craftelix.objects.Creature;
import com.craftelix.renderer.Renderer;
import com.craftelix.world.World;

public class MoveCreaturesAction implements Action {
    @Override
    public void run(World world, Renderer renderer) {
//        world.getCreatures().forEach(Creature::makeMove);
        for (Creature creature : world.getCreatures()) {
            creature.makeMove();
            renderer.render();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
