package com.revature.leaguedex;
//
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DexRepository {
    private List<String> pocketChamps;
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
            Champion temp = new Champion(champColumns[2]);
            this.pocketChamps.add(scanner.next());
        }
    }

    public List<Champion> getPocketChamps() {return pocketChamps;}

    public Champion getChamp(String name){
        for(Champion champion : this.pocketChamps) {
            if (champion.getName().equals {
                result = champion;
            }
        }
        return result;
    }
}
