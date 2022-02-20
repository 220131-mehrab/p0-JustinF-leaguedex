package com.revature.leaguedex;

import com.revature.leaguedex.repository.DexRepository;
import com.revature.leaguedex.repository.SQLDexRepository;
import com.revature.leaguedex.servlet.DefaultServlet;
import com.revature.leaguedex.servlet.DexServlet;
import com.revature.leaguedex.service.LeagueDexService;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

public class App {

    public static void main(String[] args) {
        String webAppName = "";
        DexRepository dexRepository;
        //DexRepository dexRepository = new DexRepository("leagueChamps.csv");
        //dexRepository = new inMemoryDexRepository();
        dexRepository = new SQLDexRepository();
        LeagueDexService leagueDexService= new LeagueDexService(dexRepository);

        Tomcat server = new Tomcat();
        server.setBaseDir(System.getProperty("java.io.tmpdir"));
        server.setPort(8080);
        server.getConnector();
        server.addContext(webAppName,null);

        server.addServlet(webAppName,"defaultServlet", new DefaultServlet()).addMapping("/*");
        server.addServlet(webAppName,"dexServlet", new DexServlet()).addMapping("/champion");


        try {
            server.start();
            System.out.println("Server running on http://localhost:"+ server.getConnector().getLocalPort());
            server.getServer().await();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }

    }
}
