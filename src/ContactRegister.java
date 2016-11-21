import java.util.List;

public class ContactRegister {
    private ContactListFileHandler clf = new ContactListFileHandler();

    public ContactRegister() {
        this.contactList = clf.loadListFromFile();
    }

    private List<Contact> contactList;

    public void addContactToList(String firstName, String lastName, String eMail) {
        contactList.add(new Contact(firstName, lastName, eMail));
    }

    public void printConatctList() {
        contactList.forEach(System.out::println);
    }

    public void searchContact(String query) {
        contactList.stream().filter(contact -> contact.getFirstName().toLowerCase().startsWith(query)
                || contact.getLastName().toLowerCase().startsWith(query)).forEach(System.out::println);
    }

    public void saveList() {
        clf.saveListToDisk(contactList);
    }
}
