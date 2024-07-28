package com.craftelix.actions;

import com.craftelix.objects.Grass;
import com.craftelix.objects.Herbivore;
import com.craftelix.renderer.Renderer;
import com.craftelix.world.World;

public class AddEntityAction implements Action {
    @Override
    public void perform(World world, Renderer renderer) {
        boolean update = false;

        int herbivoreCount = world.herbivore.size();
        if (herbivoreCount <= world.defaultValues.herbivoreCount / 4) {
            int newHerbivoresCount = world.defaultValues.herbivoreCount - herbivoreCount;
            System.out.printf("На карте осталось мало травоядных. Добавлено %d объектов\n", newHerbivoresCount);
            ActionUtils.addEntities(world, Herbivore.class, newHerbivoresCount);
            update = true;
        }

        int resourcesCount = world.getCellsBy(Grass.class).size();
        if (resourcesCount <= world.defaultValues.resourceCount / 4) {
            int newResourcesCount = world.defaultValues.resourceCount - resourcesCount;
            System.out.printf("На карте осталось мало травы для травоядных. Добавлено %d объектов\n", newResourcesCount);
            ActionUtils.addEntities(world, Grass.class, newResourcesCount);
            update = true;
        }

        if (update) {
            renderer.render(world);
        }
    }
}
