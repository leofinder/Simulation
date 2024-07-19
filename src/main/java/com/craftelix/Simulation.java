package com.craftelix;

import com.craftelix.actions.Action;
import com.craftelix.map.Field;
import com.craftelix.map.ConsoleRenderer;
import com.craftelix.map.Renderer;

import java.util.ArrayList;
import java.util.List;

public class Simulation {

    private boolean auto;
    private int moveCounter = 0;
    private Field field;
    private Renderer renderer;
    private List<Action> initActions = new ArrayList<>();
    private List<Action> turnActions = new ArrayList<>();

    public Simulation(Field field, Renderer renderer) {
        this.field = field;
        this.renderer = renderer;
    }

    public void nextTurn() {
        renderer.render();
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
