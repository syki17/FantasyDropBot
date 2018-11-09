package com.apps.jakub.fantasydropbot.Models;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name="fantasy_content",strict=false)
public class FantasyContent {

    @Element(name="league")
    private League league;

    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }
}
