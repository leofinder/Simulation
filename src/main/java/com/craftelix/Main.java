package com.craftelix;

import com.craftelix.map.MapGenerator;
import com.craftelix.objects.*;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        MapGenerator mapGenerator = new MapGenerator();
        Map<Integer, List<Integer>> map = mapGenerator.generate(10, 10);
        map.forEach((k, v) -> System.out.println(k + " : " + v));

        Grass grass = new Grass();
        Rock rock = new Rock();
        Tree tree = new Tree();
        Herbivore herbivore = new Herbivore(3, 100);
        Predator predator = new Predator(4, 500, 15);
        System.out.printf("%s_%s_%s_%s_%s_", grass, rock, tree, herbivore, predator);

    }
}