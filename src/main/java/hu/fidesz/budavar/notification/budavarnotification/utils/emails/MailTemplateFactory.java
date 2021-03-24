package hu.fidesz.budavar.notification.budavarnotification.utils.emails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class MailTemplateFactory {
    @Autowired
    private ApplicationContext applicationContext;

    public MailTemplate create(Class<? extends MailTemplate> type, Map<String, String> placeholderReplacements) throws Exception {
        var template = type.getConstructor().newInstance();

        var factory = applicationContext.getAutowireCapableBeanFactory();

        factory.autowireBean(template);

        return new ReplacedMailTemplate(template.getFrom(), template.getSubject(), template.getBody(), placeholderReplacements);
    }
}
