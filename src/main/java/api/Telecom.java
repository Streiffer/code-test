package api;

import java.util.List;

public interface Telecom {

    List<String> getAllTelephoneNumbers();

    List<String> getTelephoneNumbersForCustomer(final String customer) throws IllegalArgumentException;
}
