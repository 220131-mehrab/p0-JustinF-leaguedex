package com.revature.leaguedex;

public class Champion {
    private String name;
    public Champion(String name){
        this.name= name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString(){
        return this.name;
    }
}
