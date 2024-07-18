package com.craftelix;

import com.craftelix.actions.Action;
import com.craftelix.map.MapRenderer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Simulation {

    private boolean auto;
    private HashMap<Integer, List<Integer>> map;
    private int moveCounter = 0;
    private MapRenderer renderer;
    private List<Action> initActions = new ArrayList<>();
    private List<Action> turnActions = new ArrayList<>();

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
