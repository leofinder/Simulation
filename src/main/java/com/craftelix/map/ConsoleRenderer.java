package com.craftelix.map;

import com.craftelix.objects.*;

public class ConsoleRenderer extends Renderer {

    public ConsoleRenderer(Field field) {
        super(field);
    }

    @Override
    public void render() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < field.getRows(); i++) {
            for (int j = 0; j < field.getCols(); j++) {
                builder.append(getEmoji(field.getMap().get(new Cell(i, j))));
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
