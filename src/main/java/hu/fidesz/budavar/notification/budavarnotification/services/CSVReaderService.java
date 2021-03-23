package hu.fidesz.budavar.notification.budavarnotification.services;

import com.opencsv.CSVReader;
import hu.fidesz.budavar.notification.budavarnotification.entities.Email;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@Component
public class CSVReaderService {

    public List<Email> parse(String fileName){
        List<Email> emails = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(fileName))) {
            List<String[]> rows = reader.readAll();
            rows.forEach(r -> emails.add(new Email(r[0], r[1])));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return emails;
    }

}
