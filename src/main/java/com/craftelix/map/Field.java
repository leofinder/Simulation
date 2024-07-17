package com.craftelix.map;

import com.craftelix.objects.Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Field {

    private final int rows;
    private final int cols;
    private final Map<Cell, Entity> map = new HashMap<>();
    private final List<Entity> entities = new ArrayList<>();

    public Field(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public Map<Cell, Entity> getMap() {
        return map;
    }

    public List<Entity> getEntities() {
        return entities;
    }
}
