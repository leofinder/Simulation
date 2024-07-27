package com.craftelix.actions;

import com.craftelix.objects.Creature;
import com.craftelix.objects.Herbivore;
import com.craftelix.renderer.Renderer;
import com.craftelix.world.World;

import java.util.List;
import java.util.Objects;

public class MoveCreaturesAction implements Action {
    @Override
    public void run(World world, Renderer renderer) {
        List<Creature> creatures = world.getCreatures();
        for (int i = 0; i < creatures.size(); i++) {
            Creature creature = creatures.get(i);
            if (creature instanceof Herbivore && creature.getHealth() == 0) {
                creatures.set(i, null);
            }
            creature.makeMove();
            renderer.render();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        world.getCreatures().removeIf(Objects::isNull);
    }
}
