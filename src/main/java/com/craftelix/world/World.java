package com.craftelix.world;

import com.craftelix.objects.Creature;
import com.craftelix.objects.Entity;
import com.craftelix.objects.Herbivore;
import com.craftelix.objects.Predator;

import java.util.*;

public class World {

    public final int rows;
    public final int cols;
    public final DefaultValues defaultValues;
    public final Map<Cell, Entity> map = new HashMap<>();
    public final List<Predator> predators = new ArrayList<>();
    public final List<Herbivore> herbivore = new ArrayList<>();

    public World(int rows, int cols, DefaultValues defaultValues) {
        this.rows = rows;
        this.cols = cols;
        this.defaultValues = defaultValues;
    }

    public void addEntity(Cell cell, Entity entity) {
        if (entity instanceof Predator) {
            ((Predator) entity).setCell(cell);
            predators.add((Predator) entity);
        } else if (entity instanceof Herbivore) {
            ((Herbivore) entity).setCell(cell);
            herbivore.add((Herbivore) entity);
        }
        map.put(cell, entity);
    }

    public void removeEntity(Cell cell) {
        map.remove(cell);
    }

    public Entity getEntity(Cell cell) {
        return map.get(cell);
    }

    public void moveCreatureTo(Cell cell, Creature creature) {
        removeEntity(creature.getCell());
        creature.setCell(cell);
        map.put(cell, creature);
    }

    public boolean isCellEmpty(Cell cell) {
        return !map.containsKey(cell);
    }

    public Set<Cell> getCellsBy(Class<? extends Entity> targetClass) {
        Set<Cell> targetCells = new HashSet<>();
        for (Map.Entry<Cell, Entity> entry : map.entrySet()) {
            if (entry.getValue().getClass().equals(targetClass)) {
                targetCells.add(entry.getKey());
            }
        }
        return targetCells;
    }

}
