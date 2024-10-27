import Contact.*;
import java.util.Scanner;

/*
 * 
 */
public class PhoneBookApplication {
    // change the name to phone book application
    // separate the class into separate file
    // move the contact logic to the main function
    // merge the duplicates
    // change the stdout to map
    // study about the lombark
    public static void main(String[] args) {
        PhoneBook pb = new PhoneBook();
        System.out.println("Scenario 1 : Create an account in the Phonebook where email is the primary");
        pb.createAccount("SuperStar", "Thalaivar", "Chennai", "superstar@gmail.com");

        // mocking the data
        // Scenario based on 
        // Entering wrong password
        System.out.println("\n\n");
        System.out.println("Scenario 2 : Entering wrong password");
        pb.isValidCredentials("anna@gmail.com", "Anna");

        System.out.println("\n\n");
        System.out.println("Scenario 3 : Entering valid Credentials");
        User user = pb.isValidCredentials("superstar@gmail.com", "Thalaivar");
        Contact contact = user.contact;
        System.out.println("\n\n");
        System.out.println("Scenario 4 : Adding a contacts to the list");
        System.out.println("Contact Name : RajKumar and number : 9876545210");
        System.out.println(contact.addContact("RajKumar", "9876545210"));
        System.out.println("Contact Name : Sakthi and number : 6876545210");
        System.out.println(contact.addContact("Sakthi", "6876545210"));
        System.out.println("Contact Name : Balu and number : 9816545210");
        System.out.println(contact.addContact("Balu", "9816545210"));
        System.out.println("\n\n");


        System.out.println("Scenario 6 : Adding a new number to the existing contact RajKumar");
        System.out.println("Contact Name : RajKumar and number : 9876545220");
        System.out.println(contact.addContact("RajKumar", "9876545220"));
        System.out.println("\n\n");

        System.out.println("Scenario 7 : Adding a new number to the existing contact");
        System.out.println("Contact Name : Raj and number : 7876545220");
        System.out.println(contact.addContact("Raj", "7876545220"));
        System.out.println("Contact Name : Balu and number : 9476545220");
        System.out.println(contact.addContact("Balu", "9476545220"));
        System.out.println("\n\n");

        System.out.println("Scenario 8 : Displaying the contact list after adding the contacts");
        contact.displayAllContacts();
        System.out.println("\n\n");

        System.out.println("Scenario 9 : Search through the contact list by a keyword : kumar" );
        contact.searchKeyWordInContactList("kumar");
        System.out.println("\n\n");

        System.out.println("Scenario 10 : Update the existing contact name from Raj to Naveen");
        contact.updateContactNameInContactList("Raj", "Naveen");
        System.out.println("\n\n");

        System.out.println("Scenario 11 : Delete the contact Sakthi from the list");
        contact.deleteContactInContactList("Sakthi");
        System.out.println("\n\n");

        System.out.println("Scenario 12 : Delete the number from a contact");
        contact.deleteNumberInContactList("9876545220");
        System.out.println("\n\n");

        System.out.println("Scenario 13 : Displaying the contact list after update and delete");
        contact.displayAllContacts();
        System.out.println("\n\n");

        




        //sc.close();
    }
}
