package com.myself.springboot;

import com.myself.springboot.listener.ConsumerApplicationStarterListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 功能描述: Application
 *
 * @author linqin.zxl
 * @date 2021/4/27
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(Application.class);
        application.addListeners(new ConsumerApplicationStarterListener());
        application.run(args);
    }
}
