import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddressBook {

    private static Map<String, Contact> contacts = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            System.out.println("Sổ Địa chỉ Menu:");
            System.out.println("1. Thêm liên hệ mới");
            System.out.println("2. Tìm liên hệ theo tên");
            System.out.println("3. Hiển thị danh bạ");
            System.out.println("4. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    addContact();
                    break;
                case 2:
                    findContact();
                    break;
                case 3:
                    displayContacts();
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập số từ 1-4.");
            }
        }
        System.out.println("Đang thoát khỏi Sổ Địa chỉ.");
    }
    private static void addContact() {
        System.out.print("Nhập tên: ");
        String name = scanner.nextLine();
        System.out.print("Nhập số điện thoại: ");
        String phone = scanner.nextLine();

        Contact contact = new Contact(name, phone);
        contacts.put(name, contact);
        System.out.println("Đã thêm liên hệ thành công.");
    }

    private static void findContact() {
        System.out.print("Nhập tên để tìm liên hệ: ");
        String name = scanner.nextLine();
        Contact contact = contacts.get(name);
        if (contact != null) {
            System.out.println("Số điện thoại của " + name + ": " + contact.getPhoneNumber());
        } else {
            System.out.println("Không tìm thấy liên hệ.");
        }
    }

    private static void displayContacts() {
        if (contacts.isEmpty()) {
            System.out.println("Không có liên hệ để hiển thị.");
        } else {
            System.out.println("Các liên hệ trong Sổ Địa chỉ:");
            for (Contact contact : contacts.values()) {
                System.out.println("Tên: " + contact.getName() + ", Số điện thoại: " + contact.getPhoneNumber());
            }
        }
    }
}