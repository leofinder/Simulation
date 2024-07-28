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
            action.perform(world, renderer);
        }
        moveCounter++;
        sleep();
    }

    public void start() {
        for (Action action : initActions) {
            action.perform(world, renderer);
        }
        loop();
    }

    public void loop() {
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

    private void sleep() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void quit() {
        this.running = false;
    }

    public boolean isAuto() {
        return auto;
    }
}
