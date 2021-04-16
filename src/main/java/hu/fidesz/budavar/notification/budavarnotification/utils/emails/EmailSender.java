package hu.fidesz.budavar.notification.budavarnotification.utils.emails;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import java.util.Map;

@Component
public class EmailSender {
    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private MailTemplateFactory factory;

    private final Logger logger = LoggerFactory.getLogger(EmailSender.class);

//    @Async
    public void send(String from, String to, String subject, String body) throws MessagingException {
        logger.info("Sending e-mail");

        var mail = javaMailSender.createMimeMessage();
        var mailHelper = new MimeMessageHelper(mail);

        // abplusz smtp bug:
        // a mailHelper.setFrom() tobb sorba tori a From headert,
        // ezt az abplusz smtp szerver rosszul dolgozza fel, es nem irja
        // ala DKIM-el a mailt. ezert helyette a setHeader-t kell hasznalni,
        // az nem tordel.
        // FONTOS: ez most beegetett From cim, minden level errol megy ki!
        mail.setHeader("From", "=?utf-8?q?B=C3=B6r=C3=B6cz_L=C3=A1szl=C3=B3?= <kapcsolat@boroczlaszlo.hu>");

        mailHelper.setTo(to);
        mailHelper.setSubject(subject);
        mailHelper.setText(body, true);
        mailHelper.setValidateAddresses(false);

        javaMailSender.send(mail);
        logger.info("Email sent");
    }

    //@Async
    public void send(String to, Class<? extends MailTemplate> type, Map<String, String> placeholderReplacements) throws Exception {
        logger.info(String.format("Preparing to send e-mail with template %s", type.toString()));

        var template = factory.create(type, placeholderReplacements);

        send(template.getFrom(), to, template.getSubject(), template.getBody());
    }
}
