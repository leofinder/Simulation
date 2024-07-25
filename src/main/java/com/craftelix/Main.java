package com.craftelix;

import com.craftelix.actions.Action;
import com.craftelix.actions.AddEntityAction;
import com.craftelix.actions.MapGeneratorAction;
import com.craftelix.actions.MoveCreaturesAction;
import com.craftelix.objects.Grass;
import com.craftelix.objects.Herbivore;
import com.craftelix.renderer.ConsoleRenderer;
import com.craftelix.renderer.Renderer;
import com.craftelix.strategy.BreadthFirstSearchStrategy;
import com.craftelix.strategy.SearchStrategyUtils;
import com.craftelix.world.Cell;
import com.craftelix.world.DefaultValues;
import com.craftelix.world.World;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        //testBFS();

        DefaultValues defaultValues = new DefaultValues(7, 10, 20, 40,
                new BreadthFirstSearchStrategy());

        World world = new World(10, 30, defaultValues);
        Renderer renderer = new ConsoleRenderer(world);
        List<Action> initActions = new ArrayList<>();
        initActions.add(new MapGeneratorAction());
        List<Action> turnActions = new ArrayList<>();
        turnActions.add(new AddEntityAction());
        turnActions.add(new MoveCreaturesAction());
        Simulation simulation = new Simulation(world, renderer, initActions, turnActions);
        Thread threadSimulation = new Thread(simulation::start);
        threadSimulation.start();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.next();
            if ("p".equalsIgnoreCase(input)) {
                simulation.pause();
            } else if ("q".equalsIgnoreCase(input)) {
                simulation.setRunning();
                break;
            } else if ("n".equalsIgnoreCase(input)) {
                simulation.nextTurn();
            }
        }

   }

    public static void testBFS() {
        DefaultValues defaultValues = new DefaultValues(0, 5, 5, 0,
                new BreadthFirstSearchStrategy());
        World world = new World(10, 10, defaultValues);
        MapGeneratorAction action = new MapGeneratorAction();
        Renderer renderer = new ConsoleRenderer(world);
        action.run(world, renderer);
        Set<Cell> targetCells = SearchStrategyUtils.getTargetCells(world.getMap(), Arrays.asList(Grass.class));
        Set<Cell> herbivores = SearchStrategyUtils.getTargetCells(world.getMap(), Arrays.asList(Herbivore.class));
        BreadthFirstSearchStrategy strategy = new BreadthFirstSearchStrategy();
        for (Cell cell : herbivores) {
            List<Cell> path = strategy.getPathToTargetCell(world.getMap(), cell, targetCells);
            System.out.println();
            System.out.println("Path: " + path);
            System.out.println("========================================================================");
        }

    }
}