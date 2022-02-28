package com.revature.leaguedex.domain;

import java.util.*;

public class Champion implements Comparable<Champion> {
    private int dexId;
    private String name;
    private String type;
    private int health;


    public Champion id(int id) {
        this.dexId = id;
        return this;
    }
    public Champion name(String name) {
        this.name = name;
        return this;
    }

    public Champion type(String type) {
        this.type = type;
        return this;
    }

    public Champion health(int health) {
        this.health = health;
        return this;
    }

    public int getDexId() {
        return dexId;
    }

    public void setDexId(int dexId) {
        this.dexId = dexId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }


    public static Champion of() {
        return new Champion();
    }

    @Override
    public String toString() {
        return "Champion {" +
                "dexID=" + dexId +
                ", name='" + name +'\'' +
                ", Class=" + type +
                ", Health=" + health +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Champion champion = (Champion) o;
        // left out HP
        return dexId == champion.dexId && name.equals(champion.name) && type.equals(champion.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dexId, name, type, health);
    }

    @Override
    public int compareTo(Champion o) {
        return Integer.compare(this.dexId, o.getDexId());
    }

}
