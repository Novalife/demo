package club.daixy.async;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class AsyncTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(AsyncTaskApplication.class, args);
    }

}
