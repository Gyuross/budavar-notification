package hu.fidesz.budavar.notification.budavarnotification.controllers;

import hu.fidesz.budavar.notification.budavarnotification.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    private final EmailService emailService;

    @Autowired
    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @RequestMapping("/send")
    public String send() {
        emailService.importEmails();
        emailService.sendReminders();
        return "ok";
    }

}
