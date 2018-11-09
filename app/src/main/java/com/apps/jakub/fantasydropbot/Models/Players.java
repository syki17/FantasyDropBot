package com.apps.jakub.fantasydropbot.Models;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name="players",strict=false)
public class Players {
    @Element(name="player")
    private List<Player> player;

    public List<Player> getPlayer() {
        return player;
    }

    public void setPlayer(List<Player> player) {
        this.player = player;
    }
}
