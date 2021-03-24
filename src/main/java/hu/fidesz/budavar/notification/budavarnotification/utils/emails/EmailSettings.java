package hu.fidesz.budavar.notification.budavarnotification.utils.emails;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "emailsender")
public class EmailSettings {
    private String surveyLink;

    public String getSurveyLink() {
        return surveyLink;
    }

    public void setSurveyLink(String surveyLink) {
        this.surveyLink = surveyLink;
    }
}
