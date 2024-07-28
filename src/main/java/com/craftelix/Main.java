package com.craftelix;

import com.craftelix.actions.Action;
import com.craftelix.actions.AddEntityAction;
import com.craftelix.actions.MapGeneratorAction;
import com.craftelix.actions.MoveCreaturesAction;
import com.craftelix.renderer.ConsoleRenderer;
import com.craftelix.renderer.Renderer;
import com.craftelix.strategy.BreadthFirstSearchStrategy;
import com.craftelix.world.DefaultValues;
import com.craftelix.world.World;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        DefaultValues defaultValues = new DefaultValues(7, 10, 20, 40,
                new BreadthFirstSearchStrategy());
        World world = new World(10, 30, defaultValues);
        Renderer renderer = new ConsoleRenderer();
        List<Action> initActions = new ArrayList<>();
        initActions.add(new MapGeneratorAction());
        List<Action> turnActions = new ArrayList<>();
        turnActions.add(new AddEntityAction());
        turnActions.add(new MoveCreaturesAction());
        Simulation simulation = new Simulation(world, renderer, initActions, turnActions);
        Thread threadSimulation = new Thread(simulation::start);
        threadSimulation.start();

        inputKey(simulation);
   }

   public static void inputKey(Simulation simulation) {
       Scanner scanner = new Scanner(System.in);
       while (true) {
           String input = scanner.next();
           if ("p".equalsIgnoreCase(input)) {
               simulation.pause();
           } else if ("n".equalsIgnoreCase(input)) {
               if (!simulation.isAuto()) {
                   simulation.nextTurn();
               }
           } else if ("q".equalsIgnoreCase(input)) {
               simulation.quit();
               break;
           }
       }
   }
}