import java.util.ArrayList;
import java.util.Scanner;

// A class to hold user data
class User {
    String name;
    String email;
    String password;

    User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
}

public class Signup {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<User> userList = new ArrayList<>();

        while (true) {
            System.out.println("\n=== Signup Page ===");

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Email: ");
            String email = sc.nextLine();

            // Check if email already exists
            boolean exists = false;
            for (User u : userList) {
                if (u.email.equalsIgnoreCase(email)) {
                    exists = true;
                    break;
                }
            }

            if (exists) {
                System.out.println("⚠️ Email already registered. Try again.");
                continue;
            }

            System.out.print("Enter Password: ");
            String password = sc.nextLine();

            // Add new user
            User newUser = new User(name, email, password);
            userList.add(newUser);

            System.out.println("✅ Signup successful!");

            System.out.print("Do you want to signup another user? (yes/no): ");
            String choice = sc.nextLine();

            if (!choice.equalsIgnoreCase("yes")) {
                break;
            }
        }

        // Show all registered users
        System.out.println("\n=== Registered Users ===");
        for (User u : userList) {
            System.out.println("Name: " + u.name + ", Email: " + u.email);
        }

        sc.close();
    }
}
