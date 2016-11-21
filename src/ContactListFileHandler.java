import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ContactListFileHandler {
    private File savedContacts = new File("savedContactList");

    public void saveListToDisk(List<Contact> listOfObjects) {
        if (listOfObjects.size() > 0) {
            try (FileOutputStream fos = new FileOutputStream(savedContacts);
                 ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                oos.writeObject(listOfObjects);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public List<Contact> loadListFromFile() {
        if (savedContacts.exists()) {
            try (FileInputStream is = new FileInputStream(savedContacts);
                 ObjectInputStream ois = new ObjectInputStream(is)) {
                return (List<Contact>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return new ArrayList<>();
    }
}
