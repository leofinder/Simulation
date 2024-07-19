package com.craftelix;

import com.craftelix.map.ConsoleRenderer;
import com.craftelix.map.Field;
import com.craftelix.map.MapGenerator;
import com.craftelix.map.Renderer;
import com.craftelix.objects.Grass;

public class Main {
    public static void main(String[] args) {
        Field field = new Field(10, 30);
        MapGenerator mapGenerator = new MapGenerator();
        mapGenerator.init(field, 7, 10);
        Renderer renderer = new ConsoleRenderer(field);
        Simulation simulation = new Simulation(field, renderer);
        simulation.nextTurn();
    }
}