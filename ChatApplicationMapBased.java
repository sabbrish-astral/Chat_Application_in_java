import java.util.*;

public class ChatApplicationMapBased {
    static HashMap<String, String[]> map = new HashMap<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n--- Chat Application Menu ---");
            System.out.println("1. Add User");
            System.out.println("2. Delete User");
            System.out.println("3. Block User");
            System.out.println("4. Unblock User");
            System.out.println("5. View Blocked Users");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();  // consume newline

            switch (choice) {
                case 1: addUser();
                case 2 : deleteUser();
                case 3 : blockUser();
                case 4 : unblockUser();
                case 5 : viewBlockedUsers();
                case 6 : System.out.println("Exiting...");
                default : System.out.println("Invalid choice!");
            }
        } while (choice != 6);
    }

    private static void addUser() {
        System.out.print("Enter new user name: ");
        String name = sc.nextLine();
        if (map.containsKey(name) && map.get(name)[0].equals("active")) {
            System.out.println("User already exists.");
        } else {
            map.put(name, new String[]{"active", ""});
            System.out.println("User added successfully.");
        }
    }

    private static void deleteUser() {
        System.out.print("Enter user name to delete: ");
        String name = sc.nextLine();
        if (map.containsKey(name) && map.get(name)[0].equals("active")) {
            map.get(name)[0] = "deleted";
            // Remove from other users' block lists
            for (Map.Entry<String, String[]> entry : map.entrySet()) {
                if (!entry.getKey().equals(name)) {
                    String[] blockedList = entry.getValue()[1].split(",");
                    blockedList = Arrays.stream(blockedList)
                            .filter(b -> !b.equals(name) && !b.isBlank())
                            .toArray(String[]::new);
                    entry.getValue()[1] = String.join(",", blockedList);
                }
            }
            System.out.println("User deleted successfully.");
        } else {
            System.out.println("User not found or already deleted.");
        }
    }

    private static void blockUser() {
        System.out.print("Enter your username: ");
        String blocker = sc.nextLine();
        System.out.print("Enter the username to block: ");
        String blockee = sc.nextLine();

        if (!validUser(blocker) || !validUser(blockee)) {
            System.out.println("Both users must exist and be active.");
        } else if (blocker.equals(blockee)) {
            System.out.println("Cannot block yourself.");
        } else {
            String[] blockedList = map.get(blocker)[1].split(",");
            Set<String> blockedSet = new HashSet<>(Arrays.asList(blockedList));
            blockedSet.add(blockee);
            map.get(blocker)[1] = String.join(",", blockedSet);
            System.out.println(blockee + " has been blocked by " + blocker);
        }
    }

    private static void unblockUser() {
        System.out.print("Enter your username: ");
        String blocker = sc.nextLine();
        System.out.print("Enter the username to unblock: ");
        String blockee = sc.nextLine();

        if (!validUser(blocker)) {
            System.out.println("User does not exist.");
        } else {
            String[] blockedList = map.get(blocker)[1].split(",");
            Set<String> blockedSet = new HashSet<>(Arrays.asList(blockedList));
            if (blockedSet.remove(blockee)) {
                map.get(blocker)[1] = String.join(",", blockedSet);
                System.out.println(blockee + " has been unblocked by " + blocker);
            } else {
                System.out.println(blockee + " is not in your blocked list.");
            }
        }
    }

    private static void viewBlockedUsers() {
        System.out.print("Enter your username: ");
        String name = sc.nextLine();
        if (!validUser(name)) {
            System.out.println("User not found.");
        } else {
            String blocked = map.get(name)[1];
            if (blocked.isBlank()) {
                System.out.println("No users blocked.");
            } else {
                System.out.println("Blocked users: " + blocked);
            }
        }
    }

    private static boolean validUser(String name) {
        return map.containsKey(name) && map.get(name)[0].equals("active");
    }
}
