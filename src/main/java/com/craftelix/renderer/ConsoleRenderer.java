package com.craftelix.renderer;

import com.craftelix.world.Cell;
import com.craftelix.world.World;
import com.craftelix.objects.*;

public class ConsoleRenderer implements Renderer {

    private final World world;

    public ConsoleRenderer(World world) {
        this.world = world;
    }

    @Override
    public void render() {
        System.out.print("\033[H\033[2J");
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < world.getRows(); i++) {
            for (int j = 0; j < world.getCols(); j++) {
                builder.append(getEmoji(world.getMap().get(new Cell(i, j))));
            }
            builder.append("\n");
        }
        System.out.println(builder);
    }

    private String getEmoji(Entity entity) {
        String emoji = "⬛";
        if (entity instanceof Predator) {
            emoji = "🐺";
        } else if (entity instanceof Herbivore) {
            emoji = "\uD83D\uDC07";
        } else if (entity instanceof Grass) {
            emoji = "\uD83C\uDF40";
        } else if (entity instanceof Rock) {
            emoji = "\uD83C\uDFD4\uFE0F";
        } else if (entity instanceof Tree) {
            emoji = "\uD83C\uDF33";
        }
        return emoji;
    }
}
