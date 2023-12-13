import java.util.Scanner;

public class AddressBookServices
{
    Scanner rs = new Scanner(System.in);
    void addContact(AddressBook a)
    {
        System.out.println("Enter first name");
        String fname = rs.next();
        System.out.println("Enter last name");
        String lname = rs.next();
        System.out.println("Enter Phone number");
        String phoneNumber = rs.next();
        System.out.println("Enter ZipCode");
        int zip = rs.nextInt();
        System.out.println("Enter City");
        String city = rs.next();
        System.out.println("Enter Relation");
        String relation = rs.next();
        //Person.java constructor
        Person p1 = new Person(fname,lname,phoneNumber,zip,city,relation);
        //added to the address book instance
        a.contactList.add(p1);
    }
}
