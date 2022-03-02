package com.revature.leaguedex.servlet;

import com.revature.leaguedex.DexService;
import com.revature.leaguedex.domain.Champion;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DexServlet extends HttpServlet {
    DexService service;

    public DexServlet(DexService service) {
        this.service = service;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userInput = req.getParameter("searchName");
        resp.getWriter().println(service.searchForm());

        List<Champion> results = new ArrayList<>();
        if(userInput != null) {
            results.add(service.getChampion(userInput));
        } else {
            results.addAll(service.getChampion());
        }
        for (Champion c : results)
            resp.getWriter().println(c + "<br/>");
    }
}
