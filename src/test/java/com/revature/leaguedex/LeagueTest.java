package com.revature.leaguedex;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LeagueTest {
    @Test
    public void constructorTest() {
        String name="";
        Champion champion = new Champion(name);
    }

    @Test
    public void nameTest() {
        Champion champion = new Champion("Warwick");
        Assertions.assertEquals(champion.getName(),"Warwick");
        champion = new Champion("Riven");
        Assertions.assertEquals("Riven", champion.getName());
    }
}
