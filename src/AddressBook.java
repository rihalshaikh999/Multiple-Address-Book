import java.util.ArrayList;
import java.util.HashMap;
/*
    This class contains only String name variable and contains HashMap for Storing AddressBooks
 */
class AddressBook{
    /*
            @desc:    This class contains only String name variable and contains HashMap for Storing AddressBooks
            @param:   AddressBook class has it own constructor and parameter with it.
            @return:  Its Doesn't return anything
     */
    String Name;
    HashMap<String, Person>contactMap=new HashMap<>();
    HashMap<String, Person>cityMap=new HashMap<>();
    HashMap<String, Person>stateMap=new HashMap<>();

    AddressBook(String name) {
        this.Name = name;
    }
}