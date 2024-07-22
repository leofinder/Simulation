package com.craftelix.world;

import com.craftelix.objects.Creature;
import com.craftelix.objects.Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class World {

    private final int rows;
    private final int cols;
    private final DefaultValues defaultValues;
    private final Map<Cell, Entity> map = new HashMap<>();
    private final List<Creature> creatures = new ArrayList<>();

    public World(int rows, int cols, DefaultValues defaultValues) {
        this.rows = rows;
        this.cols = cols;
        this.defaultValues = defaultValues;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public DefaultValues getDefaultValues() {
        return defaultValues;
    }

    public Map<Cell, Entity> getMap() {
        return map;
    }

    public List<Creature> getCreatures() {
        return creatures;
    }
}
