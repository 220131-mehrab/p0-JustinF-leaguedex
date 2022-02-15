package com.revature.leaguedex;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

public class App {

    public static void main(String[] args) {
        String webAppName = "leagueDex";
        DexRepository dexRepository = new DexRepository("leagueChamps.csv");
        DexService dexService = new DexService(dexRepository);
        SearchFormService sfService= new SearchFormService();

        Tomcat server = new Tomcat();
        server.setBaseDir(System.getProperty("java.io.tmpdir"));
        server.getConnector();
        server.addContext("",null);

        server.addServlet(webAppName,"defaultServlet", new DefaultServlet()).addMapping("/*");
        server.addServlet(webAppName,"dexServlet", dexService).addMapping("/champion");
        server.addServlet(webAppName,"searchFormServlet", sfService).addMapping("/search");
        try {
            server.start();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }

    }
}
