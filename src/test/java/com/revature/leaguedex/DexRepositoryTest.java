package com.revature.leaguedex;

import com.revature.leaguedex.domain.Champion;
import com.revature.leaguedex.repository.ChampAPIDexRepository;
import com.revature.leaguedex.repository.DexRepository;
import com.revature.leaguedex.repository.SQLDexRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DexRepositoryTest {
    @Test
    public void getLeagueTest() {
        DexRepository testRepo = new DexRepository("leaguedexTest.csv");
        Champion actual = testRepo.getChampion("Warwick");
        Champion expected = new Champion("Warwick");
        Assertions.assertEquals(expected.getName(), actual.getName());
    }

    @Test
    public void getAPIChampionTest() {
        ChampAPIDexRepository testRepo = new ChampAPIDexRepository();
        System.out.println(testRepo.getChampion("Warwick"));
    }

    @Test
    public void getSQLChampionTest() {
        SQLDexRepository testRepo = new SQLDexRepository();
        Champion actual = Champion.of().id(00).name("Warwick").type1("bruiser").HP("420");
        Assertions.assertEquals(actual, testRepo.getChampion("Warwick"));
    }
}
