package api;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
public class TelecomTest {

    @Test
    public void getAllTelephoneNumbers() {
        Telecom telecom = new TelecomImpl();
        assertTrue(telecom.getAllTelephoneNumbers() != null);
        assertTrue(!telecom.getAllTelephoneNumbers().isEmpty());

    }
}
