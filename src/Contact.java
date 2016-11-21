import java.io.Serializable;
import java.util.UUID;

public class Contact implements Serializable {
    private String firstName;
    private String lastName;
    private String eMail;
    private UUID uuid;

    public Contact(String firstName, String lastName, String eMail) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.eMail = eMail;
        this.uuid = UUID.randomUUID();
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s", firstName, lastName, eMail, uuid);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
