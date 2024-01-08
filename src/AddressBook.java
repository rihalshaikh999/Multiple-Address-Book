import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
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
    HashMap<String, Person>contactMap=new HashMap<>();
    HashMap<String, Person>cityMap=new HashMap<>();
    HashMap<String, Person>stateMap=new HashMap<>();

    AddressBook(String name) {
        this.Name = name;
    }
//    void printContactCountByCity(AddressBook a) {
//        System.out.println("Contact count by City:");
//        a.cityMap.values().stream()
//                .collect(Collectors.groupingBy(Person::getCity, Collectors.counting()))
//                .forEach((city, count) -> System.out.println(city + ": " + count));
//    }
//
//    void printContactCountByState(AddressBook a) {
//        System.out.println("Contact count by State:");
//        a.stateMap.values().stream()
//                .collect(Collectors.groupingBy(Person::getState, Collectors.counting()))
//                .forEach((state, count) -> System.out.println(state + ": " + count));
//    }


}