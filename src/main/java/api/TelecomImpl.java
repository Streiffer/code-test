package api;

import backend.DatabaseSimulator;
import model.TelephoneNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TelecomImpl implements Telecom{
    private static final DatabaseSimulator databaseSimulator = new DatabaseSimulator();
    public List<TelephoneNumber> getAllTelephoneNumbers() {
        return getAllTelephoneNumbersFromDatabase();
    }

    public List<TelephoneNumber> getTelephoneNumbersForCustomer(final String customer) throws IllegalArgumentException {
        if (customer == null) {
            throw new IllegalArgumentException("Parameter customer cannot be null");
        }
        return getTelephoneNumbersForCustomerFromDatabase(customer);
    }

    public void activateTelephoneNumber(final String telephoneNumberToActivate) throws IllegalArgumentException {
        if (telephoneNumberToActivate == null) {
            throw new IllegalArgumentException("Parameter telephoneNumber cannot be null");
        }
        for (TelephoneNumber telephoneNumber : getAllTelephoneNumbersFromDatabase()) {
            if (telephoneNumber.getId().equals(telephoneNumberToActivate)) {
                telephoneNumber.setActive(true);
            }
        }
    }

    //This would normally be done with a query to the database
    private List<TelephoneNumber> getAllTelephoneNumbersFromDatabase() {
        return databaseSimulator.getTelephoneDatabase().values().stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    //This would normally be done with a query to the database
    private List<TelephoneNumber> getTelephoneNumbersForCustomerFromDatabase(final String customer) {
        List<TelephoneNumber> telephoneNumbersForCustomer = new ArrayList<>();
        List<TelephoneNumber> telephoneNumbersFromDatabase = databaseSimulator.getTelephoneDatabase().get(customer);
        if (telephoneNumbersFromDatabase != null) {
            telephoneNumbersForCustomer.addAll(telephoneNumbersFromDatabase);
        }
        return telephoneNumbersForCustomer;
    }

}
