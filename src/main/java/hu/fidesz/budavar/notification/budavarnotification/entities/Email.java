package hu.fidesz.budavar.notification.budavarnotification.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Email {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(unique = true)
    private String emailAddress;

    private String code;

    private boolean received;

    public Email() {
    }

    public Email(String emailAddress, String code) {
        this.emailAddress = emailAddress;
        this.code = code;
        this.received = false;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getCode() {
        return code;
    }

    public boolean isReceived() {
        return received;
    }

    public void setReceived(boolean received) {
        this.received = received;
    }
}
