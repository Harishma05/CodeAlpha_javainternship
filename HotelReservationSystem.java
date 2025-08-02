
import java.util.*;

class Room {
    String roomType;
    int roomNumber;
    boolean isBooked;

    Room(String type, int number) {
        this.roomType = type;
        this.roomNumber = number;
        this.isBooked = false;
    }

    public String toString() {
        return "Room " + roomNumber + " (" + roomType + ") - " + (isBooked ? "Booked" : "Available");
    }
}

public class HotelReservationSystem {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Room> rooms = new ArrayList<>();

    public static void main(String[] args) {
        // Initialize rooms
        addRooms();

        int choice;
        do {
            System.out.println("\n--- Hotel Reservation Menu ---");
            System.out.println("1. View All Rooms");
            System.out.println("2. Book a Room");
            System.out.println("3. View Booked Rooms");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: viewRooms(); break;
                case 2: bookRoom(); break;
                case 3: viewBookedRooms(); break;
                case 4: System.out.println("Thank you! Visit again."); break;
                default: System.out.println("Invalid choice.");
            }
        } while (choice != 4);
    }

    static void addRooms() {
        for (int i = 1; i <= 3; i++) rooms.add(new Room("Standard", i));
        for (int i = 4; i <= 6; i++) rooms.add(new Room("Deluxe", i));
        for (int i = 7; i <= 9; i++) rooms.add(new Room("Suite", i));
    }

    static void viewRooms() {
        System.out.println("\n--- Room List ---");
        for (Room r : rooms) System.out.println(r);
    }

    static void bookRoom() {
        System.out.print("Enter room number to book: ");
        int number = sc.nextInt();
        for (Room r : rooms) {
            if (r.roomNumber == number) {
                if (!r.isBooked) {
                    r.isBooked = true;
                    System.out.println("Room " + number + " booked successfully!");
                } else {
                    System.out.println("Room already booked!");
                }
                return;
            }
        }
        System.out.println("Invalid room number.");
    }

    static void viewBookedRooms() {
        System.out.println("\n--- Booked Rooms ---");
        boolean found = false;
        for (Room r : rooms) {
            if (r.isBooked) {
                System.out.println(r);
                found = true;
            }
        }
        if (!found) System.out.println("No rooms booked yet.");
    }
}
