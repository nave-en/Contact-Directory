package Contact;
import java.util.*;

public class PhoneBook {
    User u;
    ArrayList<User> userList = new ArrayList<>();
    /**
     * Create a account for each user
     * @param name
     * @param password
     * @param location
     * @return void
     */
    public void createAccount(String name, String password, String location) {
        u = new User();
        u.createAccount(name, password, location);
        userList.add(u);
        u.displayAccountDetails();
    }

    /**
     * Check whether the credentials is valid or not
     * @param accountId
     * @param password
     * @return void
     */
    public void isValidCredentials(int accountId, String password) {
        for (User u : userList) {
            int userAccountId = u.getAccountId();
            String userPwd = u.getPassword();
            if ((accountId == userAccountId) && (userPwd.equals(password))) {
                System.out.println("Successfully Login");
                u.userContactActionList();
                return;
            }
        }

        System.out.println("Invalid Credentials");
        return;
    }
}
class User {
    private String name;
    private int accountId;
    private String password;
    private String location;
    private Contact c;

    /**
     * Get the account id of the user
     * @return user account id
     */
    public int getAccountId() {
        return this.accountId;
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
    public void createAccount(String name, String password, String location) {
        this.name = name;
        this.accountId = (int) (Math.random() * 100) + 1;
        this.password = password;
        this.location = location;
        c = new Contact();
        System.out.println("User Account created Successfully");
    }

    /**
     * Show the user details
     * @return void
     */
    public void displayAccountDetails() {
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
        Scanner sc = new Scanner(System.in);
        boolean execCondition = true;
        while (execCondition) {
            System.out.println("Please select your Choice");
            System.out.println(
                "1. Add a contact \n" + 
                "2. Show all contact\n" + 
                "3. Contact name to search\n" +
                "4. Contact number to search\n" +
                "5. Contact name to update \n" +
                "6. Contact name to delete\n" +
                "7. Contact number to delete\n" + 
                "9. For exit"
            );
            int userChoice = sc.nextInt();
            sc.nextLine(); 
            switch (userChoice) {
                case 1:
                    System.out.println("Enter the name : ");
                    String name = sc.nextLine();
                    System.out.println("Enter the phone number : ");
                    String number = sc.nextLine();
                    c.addContact(name, number);
                    break;
                case 2:
                    c.displayAllContacts();
                    break;
                case 3:
                    String keyWord = sc.nextLine();
                    c.searchKeyWordInContactList(keyWord);
                    break;
                case 4:
                    String numberToSearch = sc.nextLine();
                    c.searchNumberInContactList(numberToSearch);
                    break;
                case 5:
                    System.out.println("Enter the current contact name");
                    String currName = sc.nextLine().toLowerCase();
                    System.out.println("Enter the contact name to update");
                    String newName = sc.nextLine();
                    c.updateContactNameInContactList(currName, newName);
                    break;
                case 6:
                    System.out.println("Enter the contact name to delete");
                    String contactNameToDelete = sc.nextLine().toLowerCase();
                    c.deleteContactInContactList(contactNameToDelete);
                    break;
                case 7:
                    System.out.println("Enter the number to delete");
                    String contactNo = sc.nextLine();
                    c.deleteNumberInContactList(contactNo);
                    break;
                case 9:
                    execCondition = false;
                    break;
                default:
                    System.out.println("Invalid Input");
                    break;
            }
        }
        sc.close();
    }
}
class Contact {
    private HashMap<String, ArrayList<String>> contactList = new HashMap<String, ArrayList<String>>();

    /**
     * Add a contact to the directory
     * @param name
     * @param number
     * @return contact creation status
     */
    public String addContact(String name, String number) {
        String isNumberAlreadyExist = this.isNumberAlreadyExist(number);
        if (isNumberAlreadyExist.length() != 0) {
            return "Number is already present in the contact name : " + isNumberAlreadyExist;
        }

        if (this.contactList.containsKey(name)) {
            ArrayList<String> updatedContactNumbers = this.contactList.get(name);
            updatedContactNumbers.add(number);
            this.contactList.put(name, updatedContactNumbers);
        } else {
            ArrayList<String> contactList = new ArrayList<>();
            contactList.add(number);
            this.contactList.put(name, contactList);
        }

        return "Name : " + name + ", Number : " + number + " was successfully added to the contact list";
    }

    /**
     * Check whether the number is exist in the conte
     * @param number
     * @return status of the number is exist or not
     */
    private String isNumberAlreadyExist(String number) {
        for (Map.Entry<String, ArrayList<String>> entry : contactList.entrySet()) {
            ArrayList<String> numbers = entry.getValue();
            if (numbers.contains(number)) {
                return entry.getKey();
            }
        }

        return "";
    }

    /**
     * Search whether the user name is exist in the contact directory or not
     * @param keyWord
     * @return void
     */
    public void searchKeyWordInContactList(String keyWord) {
        if (contactList.isEmpty()) {
            System.out.println("Your Contact List is Empty");
            return;
        }
        keyWord = keyWord.toLowerCase();
        for (Map.Entry<String, ArrayList<String>> entry : contactList.entrySet()) {
            String contactName = entry.getKey();
            if (contactName.toLowerCase().contains(keyWord)) {
                System.out.println("Similar name : " + contactName);
                ArrayList<String> numbers = entry.getValue();
                for (String number : numbers) {
                    System.out.println(number);
                }
            }
        }
    }

    /**
     * Display all the contacts in the directory in the sorted order
     * @return void
     */
    public void displayAllContacts() {
        if (contactList.isEmpty()) {
            System.out.println("Your Contact List is Empty");
            return;
        }

        // show the mapping in the sorted order
        Map<String, ArrayList<String>> sortedMap = new TreeMap<>(contactList);
        for (Map.Entry<String, ArrayList<String>> entry : sortedMap.entrySet()) {
            System.out.println("Contact Name : " + entry.getKey());
            ArrayList<String> numbers = entry.getValue();
            for (String number : numbers) {
                System.out.println(number);
            }
        }
    }

    /**
     * Check whether the number is exist or not in the directory
     * @param number
     * @return void
     */
    public void searchNumberInContactList(String number) {
        if (contactList.isEmpty()) {
            System.out.println("Your Contact List is Empty");
            return;
        }
        for (Map.Entry<String, ArrayList<String>> entry : contactList.entrySet()) {
            ArrayList<String> contactNumberList = entry.getValue();
            if (contactNumberList.contains(number)) {
                System.out.println("Contact Name contains the name : " + entry.getKey());
            }
        }
    }

    /**
     * Update the name in the contact directory
     * @param currName
     * @param nameToUpdate
     * @return void
     */
    public void updateContactNameInContactList(String currName, String nameToUpdate) {
        if (contactList.isEmpty()) {
            System.out.println("Your Contact List is Empty");
            return;
        }
        for (Map.Entry<String, ArrayList<String>> entry : contactList.entrySet()) {
            String contactName = entry.getKey();
            if (contactName.toLowerCase().equals(contactName)) {
                // first remove the key from hash map
                ArrayList<String> contactList = entry.getValue();
                this.contactList.remove(contactName);
                // then create new key in the hash map
                this.contactList.put(nameToUpdate, contactList);
                System.out.println("Contact Name successfully update from : " + currName + " to : " + nameToUpdate);
                return;
            }
        }
        System.out.println("Name not exist in the current list");
    }

    /**
     * Delete the contact in the directory based on the name
     * @param contactName
     * @return void
     */
    public void deleteContactInContactList(String contactName) {
        if (contactList.isEmpty()) {
            System.out.println("Your Contact List is Empty");
            return;
        }
        for (Map.Entry<String, ArrayList<String>> entry: contactList.entrySet()) {
            String currContactName = entry.getKey();
            if (currContactName.toLowerCase().equals(contactName)) {
                   contactList.remove(contactName);
                   System.out.println("Contact Name : " + contactName + " removed from the contact list");
            }
        }
        System.out.println("Contact Name : " + contactName + " not exist in the contact list");
    }

    /**
     * Delete the number in the directory
     * @param number
     * @return void
     */
    public void deleteNumberInContactList(String number) {
        if (contactList.isEmpty()) {
            System.out.println("Your Contact List is Empty");
            return;
        }
        for (Map.Entry<String, ArrayList<String>> entry : contactList.entrySet()) {
            ArrayList<String> contactList = entry.getValue();
            if (contactList.contains(number)) {
                contactList.remove(number);
                System.out.println("Number exist in the contact : " + entry.getKey());
                System.out.println("Number : " + number + " removed from the contact");

                return;
            }
        }
        System.out.println("Number : " + number + " not exist in the contact list");
    }
}
