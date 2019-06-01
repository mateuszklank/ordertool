package pl.i4less.ordertool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class OrdertoolApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrdertoolApplication.class, args);
    }

}