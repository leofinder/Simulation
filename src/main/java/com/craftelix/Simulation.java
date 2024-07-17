package com.craftelix;

import com.craftelix.actions.Action;
import com.craftelix.map.Field;
import com.craftelix.map.FieldRenderer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Simulation {

    private boolean auto;
    private int moveCounter = 0;
    private Field field;
    private FieldRenderer renderer;
    private List<Action> initActions = new ArrayList<>();
    private List<Action> turnActions = new ArrayList<>();

    public Simulation(Field field) {
        this.field = field;
        this.renderer = new FieldRenderer(field);
    }

    public void nextTurn() {
        // todo
    }

    public void startSimulation() {
        while (!auto) {
            nextTurn();
        }
    }

    public void pauseSimulation() {
        auto = false;
    }

}
