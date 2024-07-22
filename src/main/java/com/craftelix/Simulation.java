package com.craftelix;

import com.craftelix.actions.Action;
import com.craftelix.world.World;
import com.craftelix.renderer.Renderer;

import java.util.List;

public class Simulation {

    private boolean auto;
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
            action.run(world);
        }
        renderer.render();
        moveCounter++;
    }

    public void start() {
        for (Action action : initActions) {
            action.run(world);
        }
        auto = true;
        play();
    }

    public void play() {
        while (auto) {
            nextTurn();
            if (moveCounter == 20) {
                pause();
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void pause() {
        auto = false;
    }

}
