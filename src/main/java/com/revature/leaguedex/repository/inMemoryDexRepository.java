package com.revature.leaguedex.repository;

import com.revature.leaguedex.domain.Champion;
import com.revature.leaguedex.domain.Types;

import java.util.ArrayList;
import java.util.List;

public class inMemoryDexRepository implements DexRepository {
    private List<Champion> pocketChampions;

    public inMemoryDexRepository() {
        pocketChampions = new ArrayList<>();
        pocketChampions.add(Champion.of().id(00).name("Warwick").type1("Brusier").HP("420"));
    }

    public List<Champion> getPocketChampions() {
        return pocketChampions;
    }

    public Champion getChampion(String name) {
        Champion result = null;
        for (Champion champion : this.pocketChampions) {
            if (champion.getName().equals(name)) {
                result = champion;
            }
        }
        return result;
    }
}
