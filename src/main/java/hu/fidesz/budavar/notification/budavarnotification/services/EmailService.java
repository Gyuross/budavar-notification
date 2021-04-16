package hu.fidesz.budavar.notification.budavarnotification.services;

import hu.fidesz.budavar.notification.budavarnotification.repositories.EmailRepository;
import hu.fidesz.budavar.notification.budavarnotification.utils.emails.EmailSender;
import hu.fidesz.budavar.notification.budavarnotification.utils.emails.templates.ReminderMailTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class EmailService {

    @Autowired
    private EmailRepository emailRepository;

    @Autowired
    private EmailSender emailSender;

    private final CSVReaderService csvReaderService;

    private final String link = "https://boroczlaszlo.hu/kerdoiv/";

    @Autowired
    public EmailService(CSVReaderService csvReaderService) {
        this.csvReaderService = csvReaderService;
    }

    public void sendReminders() {
        emailRepository
                .findAll()
                .stream()
                .filter(x -> !x.isReceived())
                .forEach(email -> {
                    try {
                        emailSender.send(email.getEmailAddress(), ReminderMailTemplate.class, new HashMap<>() {{
                            put("link", link + email.getCode());
                        }});
                        email.setReceived(true);
                        emailRepository.save(email);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
    }

    public void importEmails() {
        var newEmails = csvReaderService.parse("emails.csv");
        var oldEmails = emailRepository.findAll();

        newEmails
                .stream()
                .filter(newEmail -> !oldEmails
                                        .stream()
                                        .anyMatch(oldEmail -> oldEmail.getEmailAddress().equals(newEmail.getEmailAddress())))
                .forEach(emailRepository::save);
    }
}
