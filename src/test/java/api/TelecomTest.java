package api;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;

public class TelecomTest {

    //In a real scenario it would be better to run these tests against an in memory database
    //so the tests could control the test data.

    @Test
    public void getAllTelephoneNumbers() {
        Telecom telecom = new TelecomImpl();
        assertTrue(telecom.getAllTelephoneNumbers() != null);
        assertFalse(telecom.getAllTelephoneNumbers().isEmpty());
        assertThat("List equality without order",
                Arrays.asList("073554487", "073552312", "070129583", "073003943", "075086533", "070122321"), containsInAnyOrder(telecom.getAllTelephoneNumbers().toArray(new String[telecom.getAllTelephoneNumbers().size()])));

    }


    @Test
    public void getTelephoneNumbersForCustomer(){
        Telecom telecom = new TelecomImpl();
        assertTrue(telecom.getTelephoneNumbersForCustomer("Adam") != null);
        assertFalse(telecom.getTelephoneNumbersForCustomer("Adam").isEmpty());
        assertThat("List equality without order", Arrays.asList("073554487", "073552312"), containsInAnyOrder(telecom.getTelephoneNumbersForCustomer("Adam").toArray(new String[telecom.getTelephoneNumbersForCustomer("Adam").size()])));

        assertTrue(telecom.getTelephoneNumbersForCustomer("Steven") != null);
        assertTrue(telecom.getTelephoneNumbersForCustomer("Steven").isEmpty());

        try {
            telecom.getTelephoneNumbersForCustomer(null);
            Assert.fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Parameter customer cannot be null", e.getMessage());
        }
    }
}
