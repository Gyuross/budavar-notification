package hu.fidesz.budavar.notification.budavarnotification;

import hu.fidesz.budavar.notification.budavarnotification.utils.ResourceReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmailTemplatesConfig {
    @Bean
    public String reminderMailBody() {
        return ResourceReader.readFileToString("emails/reminder.html");
    }
}
