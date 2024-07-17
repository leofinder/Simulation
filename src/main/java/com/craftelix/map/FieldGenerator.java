package com.craftelix.map;

import com.craftelix.objects.Entity;
import com.craftelix.objects.Herbivore;
import com.craftelix.objects.Predator;

import java.util.*;

public class FieldGenerator {

    public void init(Field field, int predatorCount, int herbivoreCount) {
        Map<Cell, Entity> map = field.getMap();
        List<Entity> entities = field.getEntities();
        Random random = new Random();

        for (int i = 0; i < 5; i++) {
            Cell cell = new Cell(random.nextInt(field.getCols()), random.nextInt(field.getRows()));
            if (!map.containsKey(cell)) {
                Predator predator = new Predator(cell, map, random.nextInt(5, 9), 100, random.nextInt(15, 30));
                entities.add(predator);
                map.put(cell, predator);
            }
        }

        for (int i = 0; i < 7; i++) {
            Cell cell = new Cell(random.nextInt(field.getCols()), random.nextInt(field.getRows()));
            if (!map.containsKey(cell)) {
                Herbivore herbivore = new Herbivore(cell, map, random.nextInt(5, 9), 100);
                entities.add(herbivore);
                map.put(cell, herbivore);
            }
        }
    }

}
