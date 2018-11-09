package com.apps.jakub.fantasydropbot.Models;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name="transactions",strict=false)
public class Transactions {
    @ElementList(name="transactions",inline = true)
    private List<Transaction> transactionList;

    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(List<Transaction> transactionList) {
        this.transactionList = transactionList;
    }
}
