package com.craftelix.map;

import com.craftelix.objects.*;

import java.util.*;

public class MapGenerator {

    public void init(Field field, int predatorCount, int herbivoreCount) {
        int rows = field.getRows();
        int cols = field.getCols();
        validate(rows, cols, predatorCount, herbivoreCount);
        int freeCellsCount = rows * cols - (predatorCount + herbivoreCount);

        Map<Cell, Entity> map = field.getMap();
        initMap(map, rows, cols);
        List<Entity> entities = field.getEntities();
        addEntities(map, entities, Predator.class, predatorCount);
        addEntities(map, entities, Herbivore.class, herbivoreCount);
        addEntities(map, entities, Grass.class, 20);
        addEntities(map, entities, Rock.class, 20);
        addEntities(map, entities, Tree.class, 20);
    }

    private void addEntities(Map<Cell, Entity> map, List<Entity> entities, Class entityClass, int entityCount) {
        Random random = new Random();
        List<Cell> freeCells = getFreeCells(map);
        Entity  entity = null;
        for (int i = 0; i < entityCount; i++) {
            Cell cell = freeCells.get(random.nextInt(freeCells.size()));
            if (entityClass == Predator.class) {
                entity = new Predator(cell, map, 100, random.nextInt(5, 9), random.nextInt(15, 30));
                entities.add(entity);
            } else if (entityClass == Herbivore.class) {
                entity = new Herbivore(cell, map, 100, random.nextInt(5, 9));
                entities.add(entity);
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

    private List<Cell> getFreeCells(Map<Cell, Entity> map) {
        List<Cell> freeCells = new ArrayList<>();
        for (Map.Entry<Cell, Entity> entry : map.entrySet()) {
            if (entry.getValue() == null) {
                freeCells.add(entry.getKey());
            }
        }
        return freeCells;
    }

    private void initMap(Map<Cell, Entity> map, int rows, int cols) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Cell cell = new Cell(i, j);
                map.put(cell, null);
            }
        }
    }

    private void validate(int rows, int cols, int predatorCount, int herbivoreCount) {
        if (rows < 3 || cols < 3) {
            throw new IllegalArgumentException("Размер поля должен быть 3х3 или больше");
        }
        if (rows * cols < 2 * (predatorCount + herbivoreCount)) {
            throw new IllegalArgumentException(String.format(
                    "Количество существ %d не может быть размещено на поле %dх%d", predatorCount + herbivoreCount, rows, cols)
            );
        }
    }

}
