import java.util.*;
import java.util.stream.Collectors;

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
    Map<String, Person> contactMap = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
    Map<String, Person> cityMap = new HashMap<>();
    Map<String, Person> stateMap = new HashMap<>();

    AddressBook(String name) {
        this.Name = name;
    }
    List<Person> sortContactsByCity() {
        return contactMap.values().stream()
                .sorted(Comparator.comparing(Person::getCity))
                .collect(Collectors.toList());
    }

    List<Person> sortContactsByState() {
        return contactMap.values().stream()
                .sorted(Comparator.comparing(Person::getState))
                .collect(Collectors.toList());
    }

    List<Person> sortContactsByZip() {
        return contactMap.values().stream()
                .sorted(Comparator.comparingInt(Person::getZipCode))
                .collect(Collectors.toList());
    }
}