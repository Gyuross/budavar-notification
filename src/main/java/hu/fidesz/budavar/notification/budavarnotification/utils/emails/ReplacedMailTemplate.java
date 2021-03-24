package hu.fidesz.budavar.notification.budavarnotification.utils.emails;

import java.util.Map;

public class ReplacedMailTemplate implements MailTemplate {
    private final String from;
    private final String subject;
    private final String body;

    public ReplacedMailTemplate(String from, String subject, String body, Map<String, String> placeholderReplacements) {
        this.from = from;
        this.subject = replaceTokens(subject, placeholderReplacements);
        this.body = replaceTokens(body, placeholderReplacements);
    }

    private String replaceTokens(String subject, Map<String, String> placeholderReplacements) {
        return placeholderReplacements.entrySet().stream().reduce(
                subject,
                (acc, pair) -> acc.replaceAll(String.format("\\$\\{%s\\}", pair.getKey()), pair.getValue()),
                (a, b) -> a);
    }

    @Override
    public String getFrom() {
        return from;
    }

    @Override
    public String getSubject() {
        return subject;
    }

    @Override
    public String getBody() {
        return body;
    }
}
