/*
 * Copyright (c) 2024 LCLP.
 *
 * Licensed under the MIT License. For more information, consider the LICENSE file in the project's root directory.
 */

package work.lclpnet.translations.model;

import org.jetbrains.annotations.Nullable;
import work.lclpnet.translations.util.Pair;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class MutableLanguage implements Language {

    private final Map<String, String> mapping = Collections.synchronizedMap(new HashMap<>());

    @Override
    @Nullable
    public String get(String key) {
        return mapping.get(key);
    }

    @Override
    public Iterable<String> keys() {
        return mapping.keySet();
    }

    @Override
    public boolean has(String key) {
        return mapping.containsKey(key);
    }

    @Override
    public Stream<Pair<String, String>> stream() {
        return mapping.entrySet().stream().map(Pair::of);
    }

    public void add(String key, String value) {
        mapping.put(key, value);
    }

    public void addAll(Map<String, String> mapping) {
        mapping.forEach(this::add);
    }

    public void addAll(Language other) {
        if (this == other) return;

        for (String key : other.keys()) {
            String value = other.get(key);
            add(key, value);
        }
    }
}
