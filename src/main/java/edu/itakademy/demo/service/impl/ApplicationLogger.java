package edu.itakademy.demo.service.impl;

import edu.itakademy.demo.service.ApplicationLoggerInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class ApplicationLogger implements ApplicationLoggerInterface {

    private final Logger logger = LoggerFactory.getLogger(ApplicationLogger.class);

    @Autowired
    private TomcatServletWebServerFactory tomcatServletWebServerFactory;

    @Override
    @EventListener(ApplicationReadyEvent.class)
    public void log() {
        int port = this.tomcatServletWebServerFactory.getPort();
        this.logger.info("Application is running on port : " + port);
        // Ou, si on ne veux pas s'embéter avec le Logger :
        // System.out.println("Application is running on port : " + port);
    }
}
