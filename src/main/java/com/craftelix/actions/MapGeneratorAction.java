package com.craftelix.actions;

import com.craftelix.renderer.Renderer;
import com.craftelix.world.DefaultValues;
import com.craftelix.world.World;
import com.craftelix.objects.*;

public class MapGeneratorAction implements Action {

    public void perform(World world, Renderer renderer) {
        validate(world.rows, world.cols, world.defaultValues);

        ActionUtils.addEntities(world, Tree.class, world.defaultValues.staticObjectCount / 2);
        ActionUtils.addEntities(world, Rock.class, world.defaultValues.staticObjectCount / 2);
        ActionUtils.addEntities(world, Grass.class, world.defaultValues.resourceCount);
        ActionUtils.addEntities(world, Herbivore.class, world.defaultValues.herbivoreCount);
        ActionUtils.addEntities(world, Predator.class, world.defaultValues.predatorCount);

        renderer.render(world);
    }

    private void validate(int rows, int cols, DefaultValues defaultValues) {
        if (rows < 3 || cols < 3) {
            throw new IllegalArgumentException("Размер поля должен быть 3х3 или больше");
        }
        int entityCount = defaultValues.staticObjectCount + defaultValues.resourceCount + defaultValues.herbivoreCount + defaultValues.predatorCount;
        if (rows * cols <= entityCount) {
            throw new IllegalArgumentException(String.format(
                    "Количество объектов %d не может быть размещено на поле %dх%d", entityCount, rows, cols)
            );
        }
    }

}
