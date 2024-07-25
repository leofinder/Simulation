package com.craftelix;

import com.craftelix.actions.Action;
import com.craftelix.world.World;
import com.craftelix.renderer.Renderer;

import java.util.List;

public class Simulation {

    private volatile boolean auto = true;
    private volatile boolean running = true;
    private int moveCounter = 0;
    private final World world;
    private final Renderer renderer;
    private final List<Action> initActions;
    private final List<Action> turnActions;

    public Simulation(World world, Renderer renderer, List<Action> initActions, List<Action> turnActions) {
        this.world = world;
        this.renderer = renderer;
        this.initActions = initActions;
        this.turnActions = turnActions;
    }

    public void nextTurn() {
        for (Action action : turnActions) {
            action.run(world, renderer);
        }
        moveCounter++;
    }

    public void start() {
        for (Action action : initActions) {
            action.run(world, renderer);
        }
        //play();
    }

    public void play() {
        while (true) {
            if (auto) {
                nextTurn();
            }
            if (!running) {
                break;
            }
        }
    }

    public void pause() {
        if (auto) {
            auto = false;
        } else {
            auto = true;
        }
    }

    public void setRunning() {
        this.running = false;
    }
}
