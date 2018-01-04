/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vng.zing.demo.grapql;

import com.vng.zing.demo.grapql.controller.GraphQLEndpoint;
import java.util.logging.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;

/**
 *
 * @author thangbq
 */
public class HServer {

    private static final Logger logger = LogManager.getLogger(HServer.class);

    public static void setupAndRun() {

        Server server = new Server(9000);
        ServletHandler handler = new ServletHandler();
        
        //add handler here
        handler.addServletWithMapping(GraphQLEndpoint.class, "/graph");
        //finish add handler here!!
        
        try {
            server.setHandler(handler);
            server.start();
            server.join();
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
        } 
    }
}
