package api;

import model.TelephoneNumber;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.junit.Assert.*;

public class TelecomTest {

    //In a real scenario it would be better to run these tests against an in memory database
    //so the tests could control the test data.

    @Test
    public void getAllTelephoneNumbers() {
        Telecom telecom = new TelecomImpl();
        assertTrue(telecom.getAllTelephoneNumbers() != null);
        assertFalse(telecom.getAllTelephoneNumbers().isEmpty());
        assertThat("List equality without order",
                Arrays.asList(new TelephoneNumber("070122321",true), new TelephoneNumber("075086533",false), new TelephoneNumber("073003943",true), new TelephoneNumber("070129583",true), new TelephoneNumber("073552312",false), new TelephoneNumber("073554487",true)), containsInAnyOrder(telecom.getAllTelephoneNumbers().toArray(new TelephoneNumber[telecom.getAllTelephoneNumbers().size()])));

    }


    @Test
    public void getTelephoneNumbersForCustomer(){
        Telecom telecom = new TelecomImpl();
        assertTrue(telecom.getTelephoneNumbersForCustomer("Adam") != null);
        assertFalse(telecom.getTelephoneNumbersForCustomer("Adam").isEmpty());
        assertThat("List equality without order", Arrays.asList(new TelephoneNumber("073552312",false), new TelephoneNumber("073554487",true)), containsInAnyOrder(telecom.getTelephoneNumbersForCustomer("Adam").toArray(new TelephoneNumber[telecom.getTelephoneNumbersForCustomer("Adam").size()])));

        assertTrue(telecom.getTelephoneNumbersForCustomer("Steven") != null);
        assertTrue(telecom.getTelephoneNumbersForCustomer("Steven").isEmpty());

        try {
            telecom.getTelephoneNumbersForCustomer(null);
            Assert.fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Parameter customer cannot be null", e.getMessage());
        }
    }

    @Test
    public void activateTelephoneNumber() {
        Telecom telecom = new TelecomImpl();
        String telephoneNumberId = "073552312";
        List<TelephoneNumber> telephoneNumbers = telecom.getAllTelephoneNumbers();
        TelephoneNumber telephoneNumber = getTelephoneNumber(telephoneNumberId, telephoneNumbers);
        assertTrue(telephoneNumber != null);
        assertFalse(telephoneNumber.isActive());

        telecom.activateTelephoneNumber("073552312");
        List<TelephoneNumber> telephoneNumbersAfterActivation = telecom.getAllTelephoneNumbers();
        TelephoneNumber telephoneNumberAfterActivation = getTelephoneNumber(telephoneNumberId, telephoneNumbersAfterActivation);
        assertTrue(telephoneNumberAfterActivation != null);
        assertTrue(telephoneNumberAfterActivation.isActive());
    }

    private TelephoneNumber getTelephoneNumber(final String telephoneNumber, final List<TelephoneNumber> telephoneNumbers) {
        if (telephoneNumbers != null && !telephoneNumbers.isEmpty()) {
            for (TelephoneNumber number : telephoneNumbers) {
                if (number.getId().equals(telephoneNumber)) {
                    return number;
                }
            }
        }
        return null;
    }
}
