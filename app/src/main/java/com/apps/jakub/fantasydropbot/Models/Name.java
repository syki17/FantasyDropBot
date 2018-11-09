package com.apps.jakub.fantasydropbot.Models;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "name", strict = false)
public class Name {
    @Element(name = "full")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
