package com.revature.leaguedex;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.tomcat.util.http.fileupload.IOUtils;

import java.io.IOException;
import java.io.InputStream;

public class DefaultServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fileName= resp.getPathInfo().replaceFirst("/", "");
        if(fileName.equals(""))
            fileName= "index.html";
        System.out.println(fileName);
        InputStream file = getClass().getClassLoader().getResourceAsStream(fileName);
        IOUtils.copy(file, resp.getOutputStream());
    }
}
