package Contact;
import java.util.*;

public class PhoneBook {
    // no single letter variable
    // move the initialization to default constructor
    // email, user -> map for fast storing and searching
    ArrayList<User> userList = new ArrayList<>();
    /**
     * Create a account for each user
     * @param name
     * @param password
     * @param location
     * @param userMail
     * @return void
     */
    public void createAccount(String name, String password, String location, String userMail) {
        User user = new User();
        user.createAccount(name, password, location, userMail);
        userList.add(user);
        user.displayAccountDetails();
    }

    /**
     * Check whether the credentials is valid or not
     * @param accountId
     * @param password
     * @return void
     */
    public User isValidCredentials(String mail, String password) {
        for (User user : userList) {
            // change the account id to mail as a identifier
            String userMail = user.getUserMail();
            String userPwd = user.getPassword();
            if ((mail.equals(userMail)) && (userPwd.equals(password))) {
                System.out.println(userMail + " successfully Login");
                return user;
            }
        }

        System.out.println("User Mail : " + mail + " Invalid credentials");
        return new User();
    }
}
