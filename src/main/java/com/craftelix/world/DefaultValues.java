package com.craftelix.world;

import com.craftelix.strategy.SearchStrategy;

public class DefaultValues {

    public final int predatorCount;
    public final int herbivoreCount;
    public final int resourceCount;
    public final int staticObjectCount;
    public final SearchStrategy strategy;

    public DefaultValues(int predatorCount, int herbivoreCount, int resourceCount, int staticObjectCount, SearchStrategy strategy) {
        this.predatorCount = predatorCount;
        this.herbivoreCount = herbivoreCount;
        this.resourceCount = resourceCount;
        this.staticObjectCount = staticObjectCount;
        this.strategy = strategy;
    }
}
