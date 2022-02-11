package com.revature.leaguedex;

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
            this.pocketChamps.add(scanner.next());
        }
    }

    public List<String> getPocketChamps() {
        return pocketChamps;
    }
}
