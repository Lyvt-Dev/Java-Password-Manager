import javax.crypto.*;
import java.io.*;
import java.util.*;

public class Main {
    static final String SECRET_KEY = "1234567890123456"; // 16-character AES key
    static final String FILE_NAME = "passwords.dat";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PasswordManager manager = new PasswordManager(FILE_NAME, SECRET_KEY);

        while (true) {
            System.out.println("\n--- Password Manager ---");
            System.out.println("1. Generate and save new password");
            System.out.println("2. Show saved passwords");
            System.out.println("3. Exit");
            System.out.print("Choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Service name (e.g. Gmail): ");
                    String service = scanner.nextLine();
                    System.out.print("Username: ");
                    String username = scanner.nextLine();
                    String password = PasswordGenerator.generate(16);
                    System.out.println("Generated password: " + password);
                    manager.addEntry(new PasswordEntry(service, username, password));
                    manager.saveEntries();
                    break;
                case "2":
                    List<PasswordEntry> entries = manager.loadEntries();
                    for (PasswordEntry entry : entries) {
                        System.out.println(entry);
                    }
                    break;
                case "3":
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
