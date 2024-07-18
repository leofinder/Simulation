package com.craftelix.map;

import com.craftelix.objects.Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapGenerator {

    public Map<Cell, Entity> generateMap(int rows, int cols) {
        // todo
    }

    public Map<Integer, List<Integer>> generate(int rows, int cols) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                map.put(i * cols + j, setValue(i, rows, j, cols));
            }
        }
        return map;
    }

    private List<Integer> setValue(int row, int rows, int col,  int cols) {
        List<Integer> list = new ArrayList<>();

        int firstRow = row == 0 ? 0 : row - 1;
        int firstCol = col == 0 ? 0 : col - 1;
        int lastRow = row == rows - 1 ? row : row + 1;
        int lastCol = col == cols - 1 ? col : col + 1;

        for (int i = firstRow; i <= lastRow; i++) {
            for (int j = firstCol; j <= lastCol; j++) {
                list.add(i * cols + j);
            }
        }
        return list;
    }
}
