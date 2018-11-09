package com.apps.jakub.fantasydropbot.Models;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name="player",strict=false)
public class Player {
    @Element(name="name")
    private Name name;
    @Element(name="transaction_data")
    private TransactionData transactionData;

}
