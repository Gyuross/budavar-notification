package hu.fidesz.budavar.notification.budavarnotification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class BudavarNotificationApplication {

    public static void main(String[] args) {
        SpringApplication.run(BudavarNotificationApplication.class, args);
    }

}
