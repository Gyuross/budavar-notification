package hu.fidesz.budavar.notification.budavarnotification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
        "hu.fidesz.budavar.notification.budavarnotification.controllers",
        "hu.fidesz.budavar.notification.budavarnotification.repositories",
} )
public class BudavarNotificationApplication {

    public static void main(String[] args) {
        SpringApplication.run(BudavarNotificationApplication.class, args);
    }

}
