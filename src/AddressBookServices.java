import java.util.*;
import java.util.stream.Collectors;

/*
 * This class contains methods that are used in the main and other classes related to AddressBook functionality.
 */
public class AddressBookServices {

    /*
     * Scanner object for reading user input.
     */
    Scanner rs = new Scanner(System.in);
    /*
     * Method to add a new contact to the given AddressBook.
     *
     * @param a The AddressBook object to which the contact will be added.
     */
    void addContact(AddressBook a) {
        System.out.println("Enter first name");
        String fname = rs.next();

        // Check if the contact with the given name already exists
        if (a.contactMap.values().stream().noneMatch(person -> person.getFname().equalsIgnoreCase(fname))) {
            System.out.println("Enter last name");
            String lname = rs.next();
            System.out.println("Enter Phone number");
            String phoneNumber = rs.next();
            System.out.println("Enter ZipCode");
            int zip = rs.nextInt();
            System.out.println("Enter City");
            String city = rs.next();
            System.out.println("Enter State");
            String state = rs.next();
            System.out.println("Enter Relation");
            String relation = rs.next();
            Person p1 = new Person(fname, lname, phoneNumber, zip, city,state,relation);
            a.contactMap.put(fname, p1);
            a.cityMap.put(city, p1);
            a.stateMap.put(state, p1);
            System.out.println("Contact added successfully");
        } else {
            System.out.println("Duplicate entry, This Name Already Exists...!!!");
        }
    }

    /*
     * Method to update phone number, zip code, and city for a contact by name in the given AddressBook.
     *
     * @param a The AddressBook object in which the contact will be updated.
     * @param fname The first name of the contact to be updated.
     */
    void updatePhoneNumberByName(AddressBook a, String fname) {
        boolean contactFound = false;

        for (Map.Entry<String, Person> entry : a.contactMap.entrySet()) {
            Person p = entry.getValue();
            if (p.getFname().equalsIgnoreCase(fname)) {
                System.out.println("Enter your new phone Number");
                String phoneNumber = rs.next();
                System.out.println("Enter your new zip code");
                int zip = rs.nextInt();
                System.out.println("Enter your new city");
                String city = rs.next();
                System.out.println("Enter your new state");
                String state = rs.next();
                p.setPhnNo(phoneNumber);
                p.setZipCode(zip);
                p.setCity(city);
                p.setState(state);
                System.out.println("Contact Updated");
                contactFound = true;
                break;
            }
        }
        if (!contactFound) {
            System.out.println("Contact not found with the given name: " + fname);
        }
    }


    /*
     * Method to delete a contact by first name in the given AddressBook.
     *
     * @param a The AddressBook object from which the contact will be deleted.
     * @param a1 The first name of the contact to be deleted.
     */
    void deleteContactByfName(AddressBook a, String a1) {
        Iterator<Map.Entry<String, Person>> iterator = a.contactMap.entrySet().iterator();
        boolean contactFound = false;

        while (iterator.hasNext()) {
            Map.Entry<String, Person> entry = iterator.next();
            Person p = entry.getValue();
            if (p.getFname().equalsIgnoreCase(a1)) {
                iterator.remove();
                System.out.println("User deleted");
                contactFound = true;
                break;
            }
        }

        if (!contactFound) {
            System.out.println("User Not Found...!!!");
        }
    }

    /*
     * Method to display all contacts in the given AddressBook.
     *
     * @param a The AddressBook object whose contacts will be displayed.
     */
    void displayContacts(AddressBook a) {
        List<Person> sortedContacts = new ArrayList<>(a.contactMap.values());
        Collections.sort(sortedContacts);
        for (Person person : sortedContacts) {
            System.out.println(person);
        }
    }

//    static void printContactCountByCity(AddressBook a) {
//        a.printContactCountByCity(a);
//    }
//
//    static void printContactCountByState(AddressBook a) {
//        a.printContactCountByState(a);
//    }
    void printContactCountByCity(ArrayList<AddressBook> aList) {
        System.out.println("Contact count by City:");
        aList.stream()
                .flatMap(addressBook -> addressBook.cityMap.values().stream())
                .collect(Collectors.groupingBy(Person::getCity, Collectors.counting()))
                .forEach((city, count) -> System.out.println(city + ": " + count));
}

    void printContactCountByState(ArrayList<AddressBook> aList) {
        System.out.println("Contact count by State:");
        aList.stream()
                .flatMap(addressBook -> addressBook.stateMap.values().stream())
                .collect(Collectors.groupingBy(Person::getState, Collectors.counting()))
                .forEach((state, count) -> System.out.println(state + ": " + count));
    }
    void displayContactsSortedByCity(AddressBook a) {
        List<Person> sortedContacts = a.sortContactsByCity();
        displaySortedContacts(sortedContacts);
    }

    void displayContactsSortedByState(AddressBook a) {
        List<Person> sortedContacts = a.sortContactsByState();
        displaySortedContacts(sortedContacts);
    }

    void displayContactsSortedByZip(AddressBook a) {
        List<Person> sortedContacts = a.sortContactsByZip();
        displaySortedContacts(sortedContacts);
    }

    private void displaySortedContacts(List<Person> sortedContacts) {
        for (Person person : sortedContacts) {
            System.out.println(person);
        }
    }
}
