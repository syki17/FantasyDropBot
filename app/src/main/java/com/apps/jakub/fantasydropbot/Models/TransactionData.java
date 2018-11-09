package com.apps.jakub.fantasydropbot.Models;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name="transaction_data",strict = false)
public class TransactionData {
    @Element(name="type")
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
