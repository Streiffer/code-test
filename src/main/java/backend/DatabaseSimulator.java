package backend;

import java.util.*;

public class DatabaseSimulator {

    private Map<String, List<String>> telephoneDatabase = new TreeMap<>();

    public DatabaseSimulator() {
        telephoneDatabase.put("Adam", Arrays.asList("073554487", "073552312"));
        telephoneDatabase.put("Lisa", Arrays.asList("070129583", "073003943"));
        telephoneDatabase.put("Ben", Arrays.asList("075086533", "070122321"));
    }

    public Map<String, List<String>> getTelephoneDatabase() {
        return telephoneDatabase;
    }
}
