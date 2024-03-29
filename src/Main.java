import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/*
 * This class contains the main method, logic, and switch cases for AddressBook functionality.
 */
public class Main {

    /*
     * The main method handles user input and invokes various methods based on the selected options.
     */
    public static void main(String[] args) {
        // Menu options for user selection
        String menu = "Press 1: Adding A contact\nPress 2: Display All Contacts\nPress 3: Edit Contact\nPress 4: Delete Contact";

        // Scanner for user input
        Scanner sc = new Scanner(System.in);
        AddressBookServices c1 = new AddressBookServices();
        AddressBook ab=new AddressBook(null);
        // ArrayList to store multiple AddressBook instances
        ArrayList<AddressBook> aList = new ArrayList<>();

        // Creating three AddressBook instances and adding them to the ArrayList
        AddressBook a = new AddressBook("Book1");
        AddressBook b = new AddressBook("Book2");
        AddressBook c = new AddressBook("Book3");
        aList.add(a);
        aList.add(b);
        aList.add(c);

        int z = 1;
        do {
            System.out.println("1: Select Address Book\n2: Display all the address book\n3: Display all the AddressBooks City\n4: Display all the AddressBooks State\n5: City Count\n6: State Count\n7: Sort by City\n8: Sort by State\n9: Sort by Zip");
            int inp = sc.nextInt();

            switch (inp) {
                case 1:
                    System.out.println("Enter the address book you want to search");
                    String searchAddressBook = sc.next();

                    for (AddressBook a1 : aList) {
                        if (a1.Name.equalsIgnoreCase(searchAddressBook)) {
                            int choice;
                            do {
                                System.out.println("Welcome to AddressBook");
                                System.out.println(menu);

//                                AddressBookServices c1 = new AddressBookServices();
                                int input = sc.nextInt();

                                switch (input) {
                                    case 1:
                                        c1.addContact(a1);
                                        break;
                                    case 2:
                                        c1.displayContacts(a1);
                                        break;
                                    case 3:
                                        System.out.println("Enter the Name you want to update Data");
                                        String fname = sc.next();
                                        for (AddressBook a2 : aList)
                                            c1.updatePhoneNumberByName(a2, fname);
                                        break;
                                    case 4:
                                        System.out.println("Enter the Name you want to delete");
                                        String s1 = sc.next();
                                        for (AddressBook a2 : aList)
                                            c1.deleteContactByfName(a2, s1);
                                        break;
                                    default:
                                        System.out.println("Enter valid option");
                                }
                                System.out.println("Enter 0 to exit");
                                choice = sc.nextInt();
                            } while (choice != 0);
                        }
                    }
                    break;

                case 2:
//                    for (AddressBook x1 : aList)
//                        System.out.println(x1.Name + "  : " + x1);
                    aList.stream()
                            .flatMap(addressBook -> addressBook.contactMap.values().stream())
                            .forEach(System.out::println);
                    break;

                case 3:
                    System.out.println("Enter the city you want to display");
                    String city = sc.next();
                    aList.stream()
                            .flatMap(addressBook -> addressBook.contactMap.values().stream())
                            .filter(person -> person.getCity().equalsIgnoreCase(city))
                            .forEach(System.out::println);
                    break;
                case 4:
                    System.out.println("Enter the state you want to display");
                    String state = sc.next();
                    aList.stream()
                            .flatMap(addressBook -> addressBook.stateMap.values().stream())
                            .filter(person -> person.getState().equalsIgnoreCase(state))
                            .forEach(System.out::println);
                    break;
                case 5:
                    System.out.println("Enter city name to count: ");
//                    c1.printContactCountByCity(aList);
                    String cityCount=sc.next();int countCity=0;
                    for (Map.Entry<String, Person> entry : a.cityMap.entrySet()) {
                        Person p = entry.getValue();
                        if (p.getCity().equalsIgnoreCase(cityCount))
                            countCity++;
                        else
                            System.out.println("None");
                    }
                    System.out.println("COUNT:-  "+countCity);
                    break;

                case 6:
                    System.out.println("Contact count by State:");
//                    c1.printContactCountByState(aList);
                    String stateCount=sc.next();int countstate=0;
                    for (Map.Entry<String, Person> entry : a.stateMap.entrySet()) {
                        Person p = entry.getValue();
                        if (p.getState().equalsIgnoreCase(stateCount))
                            countstate++;
                        else
                            System.out.println("None");
                    }
                    System.out.println("COUNT:-  "+countstate);
                    break;
                case 7:
                    c1.displayContactsSortedByCity(a);
                    break;
                case 8:
                    c1.displayContactsSortedByState(a);
                    break;
                case 9:
                    c1.displayContactsSortedByZip(a);
                    break;
                default:
                    z = 0;
            }
        } while (z != 0);
    }
}
