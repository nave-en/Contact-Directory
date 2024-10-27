import Contact.*;
import java.util.Scanner;

public class UserContact {
    public static void main(String[] args) {
        PhoneBook pb = new PhoneBook();
        pb.createAccount("SuperStar", "Thalaivar", "Chennai");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the account Id");
        int accountId = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the password");
        String password = sc.nextLine();
        pb.isValidCredentials(accountId, password);
        sc.close();
    }
}
