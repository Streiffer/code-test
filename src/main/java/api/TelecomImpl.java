package api;

import backend.DatabaseSimulator;

import java.util.List;
import java.util.stream.Collectors;

public class TelecomImpl implements Telecom{

    public List<String> getAllTelephoneNumbers() {
        return getAllTelephoneNumbersFromDatabase();
    }

    //This would normally be done with a query to the database
    private List<String> getAllTelephoneNumbersFromDatabase() {
        DatabaseSimulator databaseSimulator = new DatabaseSimulator();
        return databaseSimulator.getTelephoneDatabase().values().stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }
}
