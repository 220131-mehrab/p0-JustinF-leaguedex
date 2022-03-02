package com.revature.leaguedex;

import com.revature.leaguedex.repository.DexRepository;
import com.revature.leaguedex.domain.Champion;
import jakarta.servlet.http.HttpServlet;

import java.util.List;

public class DexService extends HttpServlet {
    private DexRepository dexRepository;


    public DexService(DexRepository dexRepository) {

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

    public List<Champion> getChampion() {
        return dexRepository.getPocketChampions();
    }

    public Champion getChampion(String userInput) {
        return dexRepository.getChampion(userInput.trim().toUpperCase());
    }
}
