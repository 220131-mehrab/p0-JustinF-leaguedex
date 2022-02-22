package com.revature.leaguedex.domain;

import java.util.*;


public class Champion implements Comparable<Champion>{
    private int dexId;
    private String name;
    private List<Type> types;
    private String HP;

    private Champion() {
        this.types = new ArrayList<>();
    }

    public static Champion of() {
        return new Champion();
    }

    public Champion id(int id) {
        this.dexId = id;
        return this;
    }

    public Champion name(String name) {
        this.name = name;
        return this;
    }

    public Champion type1(String type1) {
        types.add(0, Type.valueOf(type1.toUpperCase()));
        return this;
    }

    public Champion HP(String HP) {
        this.HP = HP;
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

    public List<Type> getTypes() {
        return types;
    }

    public void setTypes(List<Type> types) {
        this.types = types;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "dexId=" + dexId +
                ", name='" + name + '\'' +
                ", types=" + types +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Champion champion = (Champion) o;
        return dexId == champion.dexId && name.equals(champion.name) && types.equals(champion.types);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dexId, name, types);
    }

    @Override
    public int compareTo(Champion o) {
        return Integer.compare(this.dexId, o.getDexId());
    }
}