package hu.fidesz.budavar.notification.budavarnotification.utils.emails;

public interface MailTemplate {
    String getFrom();

    String getSubject();

    String getBody();
}
