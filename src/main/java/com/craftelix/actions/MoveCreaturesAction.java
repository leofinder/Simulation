package com.craftelix.actions;

import com.craftelix.objects.Creature;
import com.craftelix.world.World;

public class MoveCreaturesAction implements Action {
    @Override
    public void run(World world) {
        world.getCreatures().forEach(Creature::makeMove);
    }
}
