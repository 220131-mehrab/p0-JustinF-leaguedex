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
        scanner.next();
        while (scanner.hasNext()) {
            String[] champColums = scanner.next().split(",");
            Champion temp = Champion.of().name(champColums[2])
                    .id(Integer.parseInt(champColums[1]))
                    .type1(champColums[3]);
                    //.type2(champColums[4]);

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
