package backend;

import model.TelephoneNumber;

import java.util.*;

public class DatabaseSimulator {

    private Map<String, List<TelephoneNumber>> telephoneDatabase = new TreeMap<>();

    public DatabaseSimulator() {
        telephoneDatabase.put("Adam", Arrays.asList(new TelephoneNumber("073554487",true), new TelephoneNumber( "073552312", false)));
        telephoneDatabase.put("Lisa", Arrays.asList(new TelephoneNumber("070129583",true), new TelephoneNumber("073003943",true)));
        telephoneDatabase.put("Ben", Arrays.asList(new TelephoneNumber("075086533",false), new TelephoneNumber("070122321",true)));
    }

    public Map<String, List<TelephoneNumber>> getTelephoneDatabase() {
        return telephoneDatabase;
    }
}
