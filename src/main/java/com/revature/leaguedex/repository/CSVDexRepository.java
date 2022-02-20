package com.revature.leaguedex.repository;

import com.revature.leaguedex.domain.Champion;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVDexRepository implements DexRepository {
    private List<Champion> pocketChampions;
    private InputStream file;

    public CSVDexRepository(String filename) {
        this.pocketChampions = new ArrayList<>();
        this.file = getClass().getClassLoader().getResourceAsStream(filename);
        load();
    }
    //load program
    private void load() {
        Scanner scanner = new Scanner(this.file);
        scanner.useDelimiter("\n");
        while (scanner.hasNext()) {
            String[] champColumns = scanner.next().split(",");
            Champion temp = Champion.of().name(champColumns[1])
                    .id(Integer.parseInt(champColumns[0]))
                    .type1(new Types(1, Type.valueof(champColumns[2].toUpperCase())));

            this.pocketChampions.add(temp);
        }
    }

    public List<Champion> getPocketChampions() {
        return pocketChampions;}

    public Champion getChampion(String name){
        Champion result= null;
        for(Champion champion : this.pocketChampions) {
            if (champion.getName().equals(name)) {
                result = champion;
            }
        }
        return result;
    }
}
