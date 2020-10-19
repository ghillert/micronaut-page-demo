package com.example;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;
import io.micronaut.runtime.Micronaut;

@Introspected(classes = {
		Page.class, Pageable.class })
public class Application {

    public static void main(String[] args) {
        Micronaut.run(Application.class, args);
    }
}
