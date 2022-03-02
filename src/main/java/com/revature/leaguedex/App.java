package com.revature.leaguedex;

import com.revature.leaguedex.repository.CSVDexRepository;
import com.revature.leaguedex.repository.DexRepository;
import com.revature.leaguedex.servlet.DefaultServlet;
import com.revature.leaguedex.servlet.DexServlet;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

public class App {
    public static void main(String[] args) {
        System.out.println("main method");
        connectToServer();
    }

    public static void connectToServer() {
        String webApp = "";
        System.out.println("connect to server method");

        //object graph with injection for server
        DexRepository dexRepository;
        dexRepository = new CSVDexRepository("leaguedex.csv");
        DexService dexService = new DexService(dexRepository);


        //Starting server
        Tomcat server = new Tomcat();
        server.setBaseDir(System.getProperty("java.io.tmpdir"));
        server.setPort(0);
        server.getConnector();
        server.addContext(webApp, null);

        server.addServlet(webApp,"defaultServlet", new DefaultServlet()).addMapping("/*");
        server.addServlet(webApp, "dexServlet", new DexServlet(dexService)).addMapping("/champion");

        try {
            server.start();
            System.out.println("Server running on http://localhost:" + server.getConnector().getLocalPort());
            server.getServer().await();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }
    }
}
