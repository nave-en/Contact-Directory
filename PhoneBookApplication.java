import Contact.*;
import java.util.Scanner;

/*
 * 
 */
public class PhoneBookApplication {
    // merge duplicates
    public static void main(String[] args) {
        PhoneBook pb = new PhoneBook();
        System.out.println("Scenario 1 : Create an account in the Phonebook where email is the primary");
        pb.createAccount("SuperStar", "Thalaivar", "Chennai", "superstar@gmail.com");
        /**
            Scenario 1 : output
            User Account created Successfully
            Display User Account Information
            User name : SuperStar
            Account id : 0
            Account password : Thalaivar
            User location : Chennai
         */

        System.out.println("\n\n");
        System.out.println("Scenario 2 : Entering wrong password");
        pb.isValidCredentials("anna@gmail.com", "Anna");
        /**
         * Scenario 2 Output
         * User Mail : anna@gmail.com Invalid credentials
         */

        System.out.println("\n\n");
        System.out.println("Scenario 3 : Entering valid Credentials");
        User user = pb.isValidCredentials("superstar@gmail.com", "Thalaivar");
        Contact contact = user.contact;
        System.out.println("\n\n");
        /**
         * Scenario 3 Output : superstar@gmail.com successfully Login
         */

        System.out.println("Scenario 4 : Adding a contacts to the list");
        System.out.println("Contact Name : RajKumar and number : 9876545210");
        System.out.println(contact.addContact("RajKumar", "9876545210"));
        System.out.println("Contact Name : Sakthi and number : 6876545210");
        System.out.println(contact.addContact("Sakthi", "6876545210"));
        System.out.println("Contact Name : Balu and number : 9816545210");
        System.out.println(contact.addContact("Balu", "9816545210"));
        System.out.println("\n\n");
        /**
         * Scenario 4 Output
            Name : RajKumar, Number : 9876545210 was successfully added to the contact list
            Name : Sakthi, Number : 6876545210 was successfully added to the contact list
            Name : Balu, Number : 9816545210 was successfully added to the contact list
         */


        System.out.println("Scenario 5 : Adding a new number to the existing contact RajKumar");
        System.out.println("Contact Name : RajKumar and number : 9876545220");
        System.out.println(contact.addContact("RajKumar", "9876545220"));
        System.out.println("\n\n");
        /**
         * Output
         * Name : RajKumar, Number : 9876545220 was successfully added to the contact list
         */

        System.out.println("Scenario 6 : Adding a new number to the existing contact");
        System.out.println("Contact Name : Raj and number : 7876545220");
        System.out.println(contact.addContact("Raj", "7876545220"));
        System.out.println("Contact Name : Balu and number : 9476545220");
        System.out.println(contact.addContact("Balu", "9476545220"));
        System.out.println("\n\n");
        /**
         * Output
         * Name : RajKumar, Number : 9876545220 was successfully added to the contact list
         * Name : Balu, Number : 9476545220 was successfully added to the contact list
         */

        System.out.println("Scenario 7 : Displaying the contact list after adding the contacts");
        contact.displayAllContacts();
        System.out.println("\n\n");
        /**
         * Output
            Contact Name : Balu
            9816545210
            9476545220
            Contact Name : Raj
            7876545220
            Contact Name : RajKumar
            9876545210
            9876545220
            Contact Name : Sakthi
            6876545210
         */

        System.out.println("Scenario 8 : Search through the contact list by a keyword : kumar" );
        contact.searchKeyWordInContactList("kumar");
        System.out.println("\n\n");
        /**
         * Output
         * Similar name : RajKumar
            9876545210
            9876545220
         */

        System.out.println("Scenario 9 : Update the existing contact name from Raj to Naveen");
        contact.updateContactNameInContactList("Raj", "Naveen");
        System.out.println("\n\n");
        /**
         * Output
         * Contact Name successfully update from : Raj to : Naveen
         */

        System.out.println("Scenario 10 : Delete the contact Sakthi from the list");
        contact.deleteContactInContactList("Sakthi");
        System.out.println("\n\n");
        /**
         * Output
         * Contact Name : Sakthi removed from the contact list
         */

        System.out.println("Scenario 11 : Delete the number from a contact");
        contact.deleteNumberInContactList("9876545220");
        System.out.println("\n\n");
        /**
         * Output
         * Number : 9876545220 removed from the contact
         */

        System.out.println("Scenario 12 : Displaying the contact list after update and delete");
        contact.displayAllContacts();
        System.out.println("\n\n");
        /*
        Output
        Contact Name : Balu
        9816545210
        9476545220
        Contact Name : Naveen
        7876545220
        Contact Name : RajKumar
        9876545210
        */

        




        //sc.close();
    }
}
