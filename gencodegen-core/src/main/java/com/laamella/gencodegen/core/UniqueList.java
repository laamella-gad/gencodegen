package com.laamella.gencodegen.core;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple list of unique strings. For more complex Block functionality, see UniqueListBlock.
 *
 * @see UniqueListBlock
 */
public class UniqueList {
    private final List<String> items = new ArrayList<>();

    protected void addString(String item, Object... args) {
        String actualItem = String.format(item, args);
        if (items.contains(actualItem)) {
            return;
        }
        items.add(actualItem);
    }

    @Override
    public String toString() {
        final StringBuilder result = new StringBuilder();
        for (final String item : items) {
            result.append(item);
        }
        return result.toString();
    }
}
