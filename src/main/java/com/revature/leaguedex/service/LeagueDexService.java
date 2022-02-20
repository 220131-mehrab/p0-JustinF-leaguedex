package com.revature.leaguedex.service;

import com.revature.leaguedex.domain.Champion;
import com.revature.leaguedex.repository.DexRepository;

import java.util.List;
import java.util.Locale;


public class LeagueDexService {
    private DexRepository dexRepository;

    public LeagueDexService(DexRepository dexRepository) {
        this.dexRepository = dexRepository;
    }


    public String searchForm() {
        String HTMLForm = "<Html>\n" +
                "<head>\n" +
                "    <Title>Search LeagueDex</Title>\n" +
                "</head>\n" +
                "<body>\n" +
                "   <h1>LeagueDex Search</h1>\n" +
                "   <form action='champion' method='get'>\n" +
                "        <input type='name' name='searchName'/>\n" +
                "        <input type='submit' value='Search'/>\n" +
                "   " +
                "    <a href='champion'>See Full LeagueDex</a>\n" +
                "</form>\n" +
                "</body>\n" +
                "</Html>";
        return HTMLForm;
    }

    public List<Champion> getChampoin() {
        return dexRepository.getPocketChampions();
    }

    public Champion getChampion(String userInput) {
        return dexRepository.getChampion(userInput.trim().toLowerCase());
    }
}
