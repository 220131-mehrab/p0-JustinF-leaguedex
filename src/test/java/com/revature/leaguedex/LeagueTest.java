/*
package com.revature.leaguedex;

import com.revature.leaguedex.domain.Champion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class LeagueTest {
    @Test
    public void constructorTest() {
        String name="";
        Champion champion = new Champion(name);
    }

    @Test
    public void builderTest() {
        Champion actual =  Champion.of().id(1).name("Warwick").class1("Bruiser").HP("420");
        Assertions.assertEquals("Warwick", actual.getName());
    }

    @Test
    public void nameTest() {
        Champion champion = new Champion("Warwick");
        Assertions.assertEquals(champion.getName(),"Warwick");
        champion = new Champion("Riven");
        Assertions.assertEquals("Riven", champion.getName());
    }

    @Test
    public void comparatorTest() {
        List<Champion> championList = Arrays.asList(
                Champion.of().id(00).name("Warwick").class1("Brusier").HP("420"),
                Champion.of().id(1).name("Warwick").class1("Brusier").HP("420"),
                Champion.of().id(2).name("Lux").class1("Support").HP("370")
        );
        System.out.println(championList.toString());

        championList.sort(null);
        System.out.println(championList.toString());

        */
/*championList.sort(new Comparator<Champion>() {
            @Override
            public int compare(Champion o1, Champion o2) {
                return Integer.compare(o1.getName().length(), o2.getName().length());
            }
        });*//*

        //one line comparator for above
        championList.sort((o1,o2) -> Integer.compare(o1.getName().length(), o2.getName().length()));

        System.out.println(championList.toString());
    }
}
*/
