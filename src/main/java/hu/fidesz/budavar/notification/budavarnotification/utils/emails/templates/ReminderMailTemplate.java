package hu.fidesz.budavar.notification.budavarnotification.utils.emails.templates;

import hu.fidesz.budavar.notification.budavarnotification.utils.emails.MailTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class ReminderMailTemplate implements MailTemplate {
    @Override
    public String getFrom() {
        return "Böröcz László <kapcsolat@boroczlaszlo.hu>";
    }

    @Override
    public String getSubject() {
        return "Budavári bérlakás konzultáció - emlékeztető";
    }

    @Autowired
    @Qualifier("reminderMailBody")
    private String body;

    @Override
    public String getBody() {
        return body;
    }
}
