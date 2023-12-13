import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String menu = "Press 1: Adding A contact\nPress 2: Display All Contacts\nPress 3: Edit Contact\nPress 4: Delete Contact";
        Scanner sc = new Scanner(System.in);
        ArrayList<AddressBook> aList = new ArrayList<>();
        AddressBook a = new AddressBook("Book1");
        AddressBook b = new AddressBook("Book2");
        AddressBook c = new AddressBook("Book3");
        aList.add(a);
        aList.add(b);
        aList.add(c);
        int z=1;
        do{
            System.out.println("1: Select Address Book\n2: Display all the address book");
            int inp = sc.nextInt();
            switch (inp) {
                case 1:
                    System.out.println("Enter the address book you want to search");
                    String searchAddressBook = sc.next();
                    for (AddressBook a1 : aList) {
                        if (a1.Name.equalsIgnoreCase(searchAddressBook))
                        {
                            int choice;
                            do {
                                System.out.println("Welcome to AddressBook");
                                System.out.println(menu);

                                AddressBookServices c1 = new AddressBookServices();
                                int input = sc.nextInt();

                                switch (input) {
                                    case 1:
                                        c1.addContact(a1);
                                        break;
                                    case 2:
                                        System.out.println(a1.contactList);
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
                case 2 :
                    for (AddressBook x1 : aList) {
                        System.out.println(x1.Name + "  : " + x1.contactList);
                    }
                    break;
            }
        }while(z!=0);

    }
}