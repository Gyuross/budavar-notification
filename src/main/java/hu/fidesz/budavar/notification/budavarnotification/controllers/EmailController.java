package hu.fidesz.budavar.notification.budavarnotification.controllers;

import hu.fidesz.budavar.notification.budavarnotification.entities.Email;
import hu.fidesz.budavar.notification.budavarnotification.repositories.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    @Autowired
    private EmailRepository emailRepository;

}
