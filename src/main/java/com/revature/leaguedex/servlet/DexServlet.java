package com.revature.leaguedex.servlet;

import com.revature.leaguedex.domain.Champion;
import com.revature.leaguedex.repository.DexRepository;
import com.revature.leaguedex.service.LeagueDexService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DexServlet extends HttpServlet {
    LeagueDexService service;

    public DexServlet(LeagueDexService service){
        this.service = service;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userInput= req.getParameter("searchName");
        resp.getWriter().println(service.searchForm());

        List<Champion> results= new ArrayList<>();
        if(userInput != null) {
            resp.getWriter().println(service.getChampion(userInput));
        } else {
            results.addAll(service.getChampoin());
        }
        for (Champion c : results)
            resp.getWriter().println(results);
    }

}

