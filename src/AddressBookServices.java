import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
public class AddressBookServices
{
    Scanner rs = new Scanner(System.in);
    void addContact(AddressBook a) {
        System.out.println("Enter first name");
        String fname = rs.next();
        if (a.contactMap.values().stream().noneMatch(person -> person.getFname().equalsIgnoreCase(fname))) {
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
            Person p1 = new Person(fname, lname, phoneNumber, zip, city, relation);
            a.contactMap.put(fname, p1);
            System.out.println("Contact added successfully");
        } else {
            System.out.println("Duplicate entry, This Name Already Exist...!!!");
        }
    }
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
                p.setPhnNo(phoneNumber);
                p.setZipCode(zip);
                p.setCity(city);
                System.out.println("Contact Updated");
                contactFound = true;
                break;
            }
        }
        if (!contactFound) {
            System.out.println("Contact not found with the given name: " + fname);
        }
    }
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
    void displayContacts(AddressBook a) {
        for (Map.Entry<String, Person> entry : a.contactMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}