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

    void updatePhoneNumberByName(AddressBook a, String fname){
        boolean flag = false;
        for (Person p : a.contactList){
            if(p.getFname().equalsIgnoreCase(fname)){
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
            }
        }
    }
}
