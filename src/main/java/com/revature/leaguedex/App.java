package com.revature.leaguedex;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import java.io.File;

public class App {

    public static void main(String[] args) {
        DexRepository dexRepository = new DexRepository("leagueChamps.csv");
        DexService dexService = new DexService(dexRepository);

        Tomcat server = new Tomcat();
        server.setBaseDir(System.getProperty("java.io.tmpdir"));
        server.getConnector();
        server.addContext("",null);
        server.addServlet("","dexServlet", dexService).addMapping("/");
        try {
            this.server.start();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }

    }
}
