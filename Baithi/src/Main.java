import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Contact> addressBook = new HashMap<>();
        int option;

        do {
            System.out.println("Address Book");
            System.out.println("1. Add new contact");
            System.out.println("2. Find a contact by name");
            System.out.println("3. Display contacts");
            System.out.println("4. Exit");
            System.out.print("Enter your option: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter contact name: ");
                    String name = scanner.next();
                    System.out.print("Enter contact phone number: ");
                    String phoneNumber = scanner.next();
                    addressBook.put(name, new Contact(name, phoneNumber));
                    System.out.println("Contact added successfully.");
                    break;
                case 2:
                    System.out.print("Enter contact name: ");
                    name = scanner.next();
                    Contact contact = addressBook.get(name);
                    if (contact != null) {
                        System.out.println("Contact found: " + contact);
                    } else {
                        System.out.println("Contact not found.");
                    }
                    break;
                case 3:
                    if (addressBook.isEmpty()) {
                        System.out.println("No contacts to display.");
                    } else {
                        System.out.println("Contacts:");
                        for (Contact c : addressBook.values()) {
                            System.out.println(c);
                        }
                    }
                    break;
                case 4:
                    System.out.println("Exiting the address book.");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (option != 4);

        scanner.close();
    }
}