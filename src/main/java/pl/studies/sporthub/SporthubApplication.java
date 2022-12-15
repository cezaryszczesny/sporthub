package pl.studies.sporthub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class SporthubApplication {

    public static void main(String[] args) {
        SpringApplication.run(SporthubApplication.class, args);
    }

}
