package com.craftelix.actions;

import com.craftelix.renderer.Renderer;
import com.craftelix.world.World;

public interface Action {
    void run(World world, Renderer renderer);
}
