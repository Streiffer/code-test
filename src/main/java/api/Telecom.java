package api;

import model.TelephoneNumber;

import java.util.List;

public interface Telecom {

    List<TelephoneNumber> getAllTelephoneNumbers();

    List<TelephoneNumber> getTelephoneNumbersForCustomer(final String customer) throws IllegalArgumentException;

    void activateTelephoneNumber(final String telephoneNumber) throws IllegalArgumentException;
}
