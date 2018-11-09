package com.apps.jakub.fantasydropbot.Models;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name="league", strict=false)
public class League {
    @Element(name="transactions")
    private Transactions transactions;

    public Transactions getTransactions() {
        return transactions;
    }

    public void setTransactions(Transactions transactions) {
        this.transactions = transactions;
    }
}
