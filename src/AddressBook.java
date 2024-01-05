import java.util.ArrayList;
import java.util.HashMap;

class AddressBook{
    String Name;
    HashMap<String, Person> contactMap = new HashMap<>();

    AddressBook(String name) {
        this.Name = name;
    }
}