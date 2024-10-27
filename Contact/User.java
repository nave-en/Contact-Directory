package Contact;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class User {
    private String name;
    private int accountId;
    private String password;
    private String location;
    private String mail;
    public Contact contact;
    private HashMap<String, User> userList;
    // private HashMap<Integer, String> menuOptions;
    private ArrayList<String> menuOptions;

    public User() {
        userList = new HashMap<>();
        menuOptions = new ArrayList<>();
        menuOptions.add("1. Add a contact\n");
        menuOptions.add("2. Show all contacts\n");
        menuOptions.add("3. Contact name to search\n");
        menuOptions.add("4. Contact number to search\n");
        menuOptions.add("5. Contact name to update\n");
        menuOptions.add("6. Contact name to delete\n");
        menuOptions.add("7. Contact number to delete\n");
        menuOptions.add("9. For exit\n");
    }

    /**
     * Get the mail of the user
     * @return user mail
     */
    public String getUserMail() {
        return this.mail;
    }

    /**
     * Get the user password
     * @return user password
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * Create the user account and also create an object in the contact class
     * @param name
     * @param password
     * @param location
     * @return void
     */
    public void createAccount(String name, String password, String location, String userMail) {
        if (userList.containsKey(userMail)) {
            System.out.println("Account Already exist for the mail : " + userMail);
            return;
        }
        this.name = name;
        this.password = password;
        this.location = location;
        this.mail = userMail;
        contact = new Contact();
        userList.put(userMail, this);
        System.out.println("User Account created Successfully");
    }

    /**
     * Show the user details
     * @return void
     */
    public void displayAccountDetails() {
        System.out.println("Display User Account Information");
        System.out.println("User name : " + this.name);
        System.out.println("Account id : " + this.accountId);
        System.out.println("Account password : " + this.password);
        System.out.println("User location : " + this.location);
    }

    /**
     * All functionalities within the user contact directory
     * @return void
     */
    public void userContactActionList() {
        //Scanner sc = new Scanner(System.in);
        //boolean execCondition = true;
        // while (execCondition) {
            System.out.println("Please select your Choice");
            for (int i = 0; i < menuOptions.size(); i++) {
                System.out.println(menuOptions.get(i));
            }
            // int userChoice = sc.nextInt();
            // sc.nextLine(); 
            // switch (userChoice) {
            //     case 1:
            //         System.out.println("Enter the name : ");
            //         String name = sc.nextLine();
            //         System.out.println("Enter the phone number : ");
            //         String number = sc.nextLine();
            //         contact.addContact(name, number);
            //         break;
            //     case 2:
            //         contact.displayAllContacts();
            //         break;
            //     case 3:
            //         String keyWord = sc.nextLine();
            //         contact.searchKeyWordInContactList(keyWord);
            //         break;
            //     case 4:
            //         String numberToSearch = sc.nextLine();
            //         contact.searchNumberInContactList(numberToSearch);
            //         break;
            //     case 5:
            //         System.out.println("Enter the current contact name");
            //         String currName = sc.nextLine().toLowerCase();
            //         System.out.println("Enter the contact name to update");
            //         String newName = sc.nextLine();
            //         contact.updateContactNameInContactList(currName, newName);
            //         break;
            //     case 6:
            //         System.out.println("Enter the contact name to delete");
            //         String contactNameToDelete = sc.nextLine().toLowerCase();
            //         contact.deleteContactInContactList(contactNameToDelete);
            //         break;
            //     case 7:
            //         System.out.println("Enter the number to delete");
            //         String contactNo = sc.nextLine();
            //         contact.deleteNumberInContactList(contactNo);
            //         break;
            //     case 9:
            //         execCondition = false;
            //         break;
            //     default:
            //         System.out.println("Invalid Input");
            //         break;
            // }
        // }
        //sc.close();
    }
}
