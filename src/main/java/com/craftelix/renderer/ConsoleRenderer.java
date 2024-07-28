package com.craftelix.renderer;

import com.craftelix.world.Cell;
import com.craftelix.world.World;
import com.craftelix.objects.*;

public class ConsoleRenderer implements Renderer {

    @Override
    public void render(World world) {
        System.out.print("\033[H\033[2J");
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < world.rows; i++) {
            for (int j = 0; j < world.cols; j++) {
                builder.append(getSprite(new Cell(i, j), world));
            }
            builder.append("\n");
        }
        System.out.println(builder);
    }

    private String getSprite(Cell cell, World world) {
        String emptySprite = "⬛";
        if (world.isCellEmpty(cell)) {
            return emptySprite;
        }
        Entity entity = world.getEntity(cell);
        switch (entity.getClass().getSimpleName()) {
            case "Predator":
                return "\uD83D\uDC3A";
            case "Herbivore":
                return "\uD83D\uDC30";
            case "Grass":
                return "\uD83C\uDF31";
            case "Rock":
                return "⛰\uFE0F";
            case "Tree":
                return "\uD83C\uDF33";
            default:
                return emptySprite;
        }
    }
}
