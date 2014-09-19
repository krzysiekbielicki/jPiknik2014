package com.example.dagger;

import dagger.ObjectGraph;

public class Injector {

    private static ObjectGraph objectGraph = null;

    public static void init(Object... modules) {
        if (objectGraph == null) {
            objectGraph = ObjectGraph.create(modules);
        } else {
            objectGraph.plus(modules);
        }
    }

    public static void reset(Object... modules) {
        objectGraph = ObjectGraph.create(modules);
    }

    public static void inject(Object target) {
        objectGraph.inject(target);
    }
}
