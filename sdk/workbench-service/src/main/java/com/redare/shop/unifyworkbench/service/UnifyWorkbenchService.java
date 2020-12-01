package com.redare.shop.unifyworkbench.service;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.util.resource.Resource;
import org.eclipse.jetty.xml.XmlConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by taoyuandi on 8/27/15.
 */
public class UnifyWorkbenchService {

    private static Logger logger = LoggerFactory
            .getLogger(UnifyWorkbenchService.class);

    public static void main(String[] args) throws Exception {
        logger.info("start UnifyWorkbenchService ... ");
        Resource fileXml = null;
        Server server = null;
        try {
            fileXml = Resource.newSystemResource("jetty.xml");
            XmlConfiguration configuration = new XmlConfiguration(fileXml);
            server = (Server) configuration.configure();
            server.start();
            logger.info("start UnifyWorkbenchService success");
        } catch (Exception e) {
            logger.error("Error", e);
            if (server != null) {
                server.stop();
            }
            logger.info("start UnifyWorkbenchService fails");
        }
    }
}

