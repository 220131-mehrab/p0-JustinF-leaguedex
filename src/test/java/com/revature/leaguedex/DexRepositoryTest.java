package com.revature.leaguedex;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DexRepositoryTest {
    @Test
    public void getLeagueTest() {
        DexRepository testRepo = new DexRepository("leaguedexTest.csv");
        Champion actual = testRepo.getChamp("Warwick");
        Champion expected = new Champion("Warwick");
        Assertions.assertEquals(expected.getName(), actual.getName());
    }
}
