package com.craftelix.actions;

import com.craftelix.objects.*;
import com.craftelix.strategy.SearchStrategy;
import com.craftelix.world.Cell;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class ActionUtils {

    private ActionUtils() {
        throw new UnsupportedOperationException("Utility class");
    }

    public static void addEntities(Map<Cell, Entity> map, Class entityClass, int entityCount, List<Creature> creatures, SearchStrategy strategy) {
        Random random = new Random();
        List<Cell> freeCells = getFreeCells(map);
        Entity entity = null;
        for (int i = 0; i < entityCount; i++) {
            Cell cell = freeCells.get(random.nextInt(freeCells.size()));
            if (entityClass == Predator.class) {
                entity = new Predator(cell, map, 100, 6, 30, strategy);
                creatures.add((Predator) entity);
            } else if (entityClass == Herbivore.class) {
                entity = new Herbivore(cell, map, 100, 9, strategy);
                creatures.add(0, (Herbivore) entity);
            } else if (entityClass == Grass.class) {
                entity = new Grass();
            } else if (entityClass == Rock.class) {
                entity = new Rock();
            } else if (entityClass == Tree.class) {
                entity = new Tree();
            }
            map.put(cell, entity);
            freeCells.remove(cell);
        }
    }

    public static void addEntities(Map<Cell, Entity> map, Class entityClass, int entityCount) {
        addEntities(map, entityClass, entityCount, null, null);
    }

    public static List<Cell> getFreeCells(Map<Cell, Entity> map) {
        List<Cell> freeCells = new ArrayList<>();
        for (Map.Entry<Cell, Entity> entry : map.entrySet()) {
            if (entry.getValue() == null) {
                freeCells.add(entry.getKey());
            }
        }
        return freeCells;
    }
}
