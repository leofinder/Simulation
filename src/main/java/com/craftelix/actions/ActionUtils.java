package com.craftelix.actions;

import com.craftelix.objects.*;
import com.craftelix.world.Cell;
import com.craftelix.world.World;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ActionUtils {

    private ActionUtils() {
        throw new UnsupportedOperationException("Utility class");
    }

    public static void addEntities(World world, Class<? extends Entity> entityClass, int entityCount) {
        Random random = new Random();
        List<Cell> freeCells = getFreeCells(world);
        for (int i = 0; i < entityCount; i++) {
            Cell cell = freeCells.get(random.nextInt(freeCells.size()));
            switch (entityClass.getSimpleName()) {
                case "Predator":
                    world.addEntity(cell, new Predator(cell, world, 100, 6, 50, world.defaultValues.strategy));
                    break;
                case "Herbivore":
                    world.addEntity(cell, new Herbivore(cell, world, 100, 9, world.defaultValues.strategy));
                    break;
                case "Grass":
                    world.addEntity(cell, new Grass());
                    break;
                case "Rock":
                    world.addEntity(cell, new Rock());
                    break;
                case "Tree":
                    world.addEntity(cell, new Tree());
                    break;
                default:
                    break;
            }
            freeCells.remove(cell);
        }
    }

    public static List<Cell> getFreeCells(World world) {
        List<Cell> freeCells = new ArrayList<>();
        for (int row = 0; row < world.rows; row++) {
            for (int col = 0; col < world.cols; col++) {
                Cell cell = new Cell(row, col);
                if (world.isCellEmpty(cell)) {
                    freeCells.add(cell);
                }
            }
        }
        return freeCells;
    }
}
