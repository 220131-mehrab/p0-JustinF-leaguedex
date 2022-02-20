package com.revature.leaguedex.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class Types {
    private int slot;
    private Type name;

    public Types() {
    }

    public Types(int slot, Type type) {
        this.slot = slot;
        this.name = type;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public Type getType() {
        return name;
    }

    public void setType(Type type) {
        this.name = type;
    }

    @JsonProperty("type")
    private void unpackType(Map<String,Object> type) {
        this.name = Type.valueOf((String) type.get("name"));
    }

    @Override
    public String toString() {
        return "Type{" +
                "slot=" + slot +
                ", type='" + name + '\'' +
                '}';
    }
}
