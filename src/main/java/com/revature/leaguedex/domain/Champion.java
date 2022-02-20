package com.revature.leaguedex.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Champion implements Comparable<Champion> {
   @JsonProperty("id")
    private int dexId;
    private String name;
    private List<Types> types;
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

    public Champion type1(Types type1) {
        this.add(type1);
        return this;
    }

    public Champion HP(String HP) {
        this.add = HP;
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

    public List<Types> getType() {
        return types;
    }

    public void setType(List<Types> types) {
        this.types = types;
    }

    @Override
    public String toString() {
        return "Champion{" +
                ", name='" + name + '\'' +
                ", type=" + types +
                ", HP=" + HP +
                '}';
    }

    @Override
    public boolean equals(Obect o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Champion champion = (Champion) o;
        return dexId == champion.dexId && name.equals(champion.name) && types.equals(champion.types);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dexId, name, types, HP);
    }

    @Override
    public int compareTo(Champion o) {
        return Integer.compare(this.dexId, o.getDexId());
    }
}