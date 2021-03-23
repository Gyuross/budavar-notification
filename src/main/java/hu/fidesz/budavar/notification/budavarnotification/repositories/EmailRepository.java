package hu.fidesz.budavar.notification.budavarnotification.repositories;

import hu.fidesz.budavar.notification.budavarnotification.entities.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EmailRepository extends JpaRepository<Email, UUID> {
}
