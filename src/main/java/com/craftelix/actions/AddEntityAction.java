package com.craftelix.actions;

import com.craftelix.objects.Grass;
import com.craftelix.objects.Herbivore;
import com.craftelix.renderer.Renderer;
import com.craftelix.strategy.SearchStrategyUtils;
import com.craftelix.world.DefaultValues;
import com.craftelix.world.World;

public class AddEntityAction implements Action {
    @Override
    public void run(World world, Renderer renderer) {
        DefaultValues defaultValues = world.getDefaultValues();
        int herbivoreCount = SearchStrategyUtils.getTargetCells(world.getMap(), Herbivore.class).size();
        if (herbivoreCount < defaultValues.herbivoreCount / 4) {
            ActionUtils.addEntities(world.getMap(), Herbivore.class, defaultValues.herbivoreCount - herbivoreCount,
                    world.getCreatures(), defaultValues.strategy);
        }
        int resourcesCount = SearchStrategyUtils.getTargetCells(world.getMap(), Grass.class).size();
        if (resourcesCount < defaultValues.resourceCount / 4) {
            ActionUtils.addEntities(world.getMap(), Grass.class, defaultValues.resourceCount - resourcesCount);
        }
        renderer.render();
    }
}
