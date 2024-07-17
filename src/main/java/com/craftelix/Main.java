package com.craftelix;

import com.craftelix.map.Cell;
import com.craftelix.map.Field;
import com.craftelix.map.FieldGenerator;
import com.craftelix.objects.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Field field = new Field(10, 30);
        FieldGenerator fieldGenerator = new FieldGenerator();
        fieldGenerator.init(field, 7, 10);
        Simulation simulation = new Simulation(field);
    }
}