import java.util.ArrayList;

class AddressBook{
    String Name;
    ArrayList<Person> contactList = new ArrayList<>();

    AddressBook(String name){
        this.Name =name;
    }
}