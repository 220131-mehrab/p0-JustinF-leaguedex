package com.revature.leaguedex;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DexRepository {
    private List<Champion> pocketChamps;
    private InputStream file;

    public DexRepository(String filename) {
        this.pocketChamps = new ArrayList<>();
        this.file = getClass().getClassLoader().getResourceAsStream(filename);
        load();
    }
    //load program
    private void load() {
        Scanner scanner = new Scanner(this.file);
        scanner.useDelimiter("\n");
        while (scanner.hasNext()) {
            String[] champColumns = scanner.next().split(",");
            Champion temp = new Champion(champColumns[1]);
            this.pocketChamps.add(temp);
        }
    }

    public List<Champion> getPocketChamps() {return pocketChamps;}

    public Champion getChampion(String name){
        Champion result= null;
        for(Champion champion : this.pocketChamps) {
            if (champion.getName().equals(name)) {
                result = champion;
            }
        }
        return result;
    }
}
