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

    private void load() {
        Scanner scanner = new Scanner(this.file);
        scanner.useDelimiter("\n");
        scanner.next();
        while (scanner.hasNext()) {
            String[] champColumns = scanner.next().split(",");
            Champion temp = Champion.of().name(champColumns[1]);
//                    .id(Integer.parseInt(champColumns[0]))
//                    .type(champColumns[2])
//                    .health(Integer.parseInt(champColumns[3]));

            this.pocketChampions.add(temp);
        }
    }

    public Champion getChampion(String name) {
        Champion result = null;
        for(Champion champion : this.pocketChampions) {
            if (champion.getName().equals(name)) {
                result = champion;
            }
        }
        return result;
    }

    public List<Champion> getPocketChampions() {
        return pocketChampions;
    }
}
