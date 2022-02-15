package com.revature.leaguedex;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;

public class SearchFormService extends HttpServlet {
    @Override
    proctected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String HTMLForm = "<Html>\n" +
                "<Head>\n" +
                "    <Title></Title>Search League" +
                "<Title</Title>\n" +
                "<Body>\n" +
                "       <h1>leaugeChamps Search</h1>\n" +
                "   form action = '\' method = 'get'>\n" +
                "       <input type='name' name=searchName" +
    }
}
