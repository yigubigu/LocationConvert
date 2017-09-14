package com.lory.boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;


@SpringBootApplication
public class Application {
    private static final Logger logger = LoggerFactory.getLogger(Application.class);
    public static void main(String[] args) {

        ConfigurableApplicationContext context = new SpringApplicationBuilder()
                .sources(Application.class)
                .bannerMode(Banner.Mode.OFF)
                .run(args);

        Application app = context.getBean(Application.class);
        app.start();
    }

    private void start() {
        try {
            double[][] gps = {{114.21892734521,29.575429778924},{114.21892734521,29.575429778924}};
            String response1 = GpsUtil.convertWGS84ToBD09(gps);
            logger.debug(response1);
        } catch (IOException e) {
            logger.error("cannot get baidu api",e);

        }
        System.out.println("Hello World!");
    }
}
