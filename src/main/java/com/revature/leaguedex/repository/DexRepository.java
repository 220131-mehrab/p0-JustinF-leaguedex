package com.revature.leaguedex.repository;

import com.revature.leaguedex.domain.Champion;

import java.util.List;

public interface DexRepository {
    Champion getChampion(String name);
    List<Champion> getPocketChampions();
}
