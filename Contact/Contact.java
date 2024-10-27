package Contact;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Contact {
    private HashMap<String, ArrayList<String>> contactList = new HashMap<String, ArrayList<String>>();

    /**
     * Add a contact to the directory
     * @param name
     * @param number
     * @return contact creation status
     */
    public String addContact(String name, String number) {
        System.out.println("function called");
        // String isNumberAlreadyExist = this.isNumberAlreadyExist(number);
        // if (isNumberAlreadyExist.length() != 0) {
        //     return "Number is already present in the contact name : " + isNumberAlreadyExist;
        // }

        // change the array list to set
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
    // private String isNumberAlreadyExist(String number) {
    //     for (Map.Entry<String, ArrayList<String>> entry : contactList.entrySet()) {
    //         ArrayList<String> numbers = entry.getValue();
    //         if (numbers.contains(number)) {
    //             return entry.getKey();
    //         }
    //     }

    //     return "";
    // }

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
        // directly initialize to tree map
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
            if (contactName.equals(currName)) {
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
            if (currContactName.toLowerCase().equals(contactName.toLowerCase())) {
                   contactList.remove(contactName);
                   System.out.println("Contact Name : " + contactName + " removed from the contact list");
                   return;
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
