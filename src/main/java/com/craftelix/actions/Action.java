package com.craftelix.actions;

import com.craftelix.renderer.Renderer;
import com.craftelix.world.World;

public interface Action {
    void perform(World world, Renderer renderer);
}
