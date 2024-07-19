package com.craftelix.map;

public abstract class Renderer {
    protected final Field field;

    Renderer(Field field) {
        this.field = field;
    }

    public abstract void render();
}
