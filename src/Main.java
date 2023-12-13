import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String menu = "Press 1: Adding A contact\nPress 2: Display All Contacts\nPress 3: Edit Contact\nPress 4: Delete Contact";
        Scanner sc = new Scanner(System.in);
        ArrayList<AddressBook> aList = new ArrayList<>();
        AddressBook a = new AddressBook("Book1");
        aList.add(a);
        int choice;
        do {
            System.out.println("Welcome to AddressBook");
            System.out.println(menu);

            AddressBookServices c1 = new AddressBookServices();
            int input = sc.nextInt();

            switch (input) {
                case 1 :
                    for (AddressBook a1 : aList)
                        c1.addContact(a1);
                    break;
                case 2:
                    for (AddressBook x1 : aList) {
                        System.out.println(x1.Name + "  : " + x1.contactList);
                    }
                    break;
                case 3:
                    System.out.println("Enter the Name you want to update Data");
                    String fname = sc.next();
                    for (AddressBook a1 : aList)
                        c1.updatePhoneNumberByName(a1, fname);
                    break;
                case 4:
                    System.out.println("Enter the Name you want to delete");
                    String s1 = sc.next();
                    for (AddressBook a1 : aList)
                        c1.deleteContactByfName(a1, s1);
                    break;
                default:
                    System.out.println("Enter valid option");
            }
            System.out.println("Enter 0 to exit");
            choice = sc.nextInt();
        } while (choice != 0);
    }
}