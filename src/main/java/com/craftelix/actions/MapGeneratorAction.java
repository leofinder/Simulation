package com.craftelix.actions;

import com.craftelix.renderer.Renderer;
import com.craftelix.world.Cell;
import com.craftelix.world.DefaultValues;
import com.craftelix.world.World;
import com.craftelix.objects.*;

import java.util.*;

public class MapGeneratorAction implements Action {

    public void run(World world, Renderer renderer) {
        int rows = world.getRows();
        int cols = world.getCols();
        DefaultValues defaultValues = world.getDefaultValues();
        validate(rows, cols, defaultValues);

        Map<Cell, Entity> map = world.getMap();
        initMap(map, rows, cols);
        List<Creature> creatures = world.getCreatures();
        ActionUtils.addEntities(map, Tree.class, defaultValues.staticObjectCount / 2);
        ActionUtils.addEntities(map, Rock.class, defaultValues.staticObjectCount / 2);
        ActionUtils.addEntities(map, Grass.class, defaultValues.resourceCount);
        ActionUtils.addEntities(map, Herbivore.class, defaultValues.herbivoreCount, creatures, defaultValues.strategy);
        ActionUtils.addEntities(map, Predator.class, defaultValues.predatorCount, creatures, defaultValues.strategy);
        renderer.render();
    }

    private void initMap(Map<Cell, Entity> map, int rows, int cols) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Cell cell = new Cell(i, j);
                map.put(cell, null);
            }
        }
    }

    private void validate(int rows, int cols, DefaultValues defaultValues) {
        if (rows < 3 || cols < 3) {
            throw new IllegalArgumentException("Размер поля должен быть 3х3 или больше");
        }
        int entityCount = defaultValues.staticObjectCount + defaultValues.resourceCount + defaultValues.herbivoreCount + defaultValues.predatorCount;
        if (rows * cols <= entityCount) {
            throw new IllegalArgumentException(String.format(
                    "Количество существ %d не может быть размещено на поле %dх%d", entityCount, rows, cols)
            );
        }
    }

}
