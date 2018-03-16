package model;

public class TelephoneNumber {
    private final String id;
    private boolean active = false;

    public TelephoneNumber(String id, boolean active) {
        this.id = id;
        this.active = active;
    }

    public String getId() {
        return id;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean equals(Object o) {
        return o instanceof TelephoneNumber && this.id.equals(((TelephoneNumber) o).getId());
    }
}
