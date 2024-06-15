package poly.com.scheduling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class J5DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(J5DemoApplication.class, args);
    }
}
