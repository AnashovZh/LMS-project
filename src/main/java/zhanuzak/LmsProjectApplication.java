package zhanuzak;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

@SpringBootApplication
public class LmsProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(LmsProjectApplication.class, args);
        System.err.println("☺ It's work ☺");
//        LocalDateTime.of(2023,8,21,15,40);
    }

}
