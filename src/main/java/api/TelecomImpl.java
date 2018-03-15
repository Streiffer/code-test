package api;

import backend.DatabaseSimulator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TelecomImpl implements Telecom{

    public List<String> getAllTelephoneNumbers() {
        return getAllTelephoneNumbersFromDatabase();
    }

    public List<String> getTelephoneNumbersForCustomer(final String customer) throws IllegalArgumentException {
        if (customer == null) {
            throw new IllegalArgumentException("Parameter customer cannot be null");
        }
        return getTelephoneNumbersForCustomerFromDatabase(customer);
    }

    //This would normally be done with a query to the database
    private List<String> getAllTelephoneNumbersFromDatabase() {
        DatabaseSimulator databaseSimulator = new DatabaseSimulator();
        return databaseSimulator.getTelephoneDatabase().values().stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    //This would normally be done with a query to the database
    private List<String> getTelephoneNumbersForCustomerFromDatabase(final String customer) {
        List<String> telephoneNumbersForCustomer = new ArrayList<>();
        DatabaseSimulator databaseSimulator = new DatabaseSimulator();
        List<String> telephoneNumbersFromDatabase = databaseSimulator.getTelephoneDatabase().get(customer);
        if (telephoneNumbersFromDatabase != null) {
            telephoneNumbersForCustomer.addAll(telephoneNumbersFromDatabase);
        }
        return telephoneNumbersForCustomer;
    }
}
