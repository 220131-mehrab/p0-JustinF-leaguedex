package com.revature.leaguedex;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;

public class SearchFormService extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
        resp.getWriter().println(HTMLForm);
    }
}
