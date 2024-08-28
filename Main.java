import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Person> people = new ArrayList<>();
    private static int idCounter = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Select operation:");
            System.out.println("1. Create");
            System.out.println("2. Read");
            System.out.println("3. Update");
            System.out.println("4. Delete");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Create
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    createPerson(name, age);
                    break;

                case 2:
                    // Read
                    readPeople();
                    break;

                case 3:
                    // Update
                    System.out.print("Enter ID of person to update: ");
                    int idToUpdate = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new age: ");
                    int newAge = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    updatePerson(idToUpdate, newName, newAge);
                    break;

                case 4:
                    // Delete
                    System.out.print("Enter ID of person to delete: ");
                    int idToDelete = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    deletePerson(idToDelete);
                    break;

                case 5:
                    // Exit
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void createPerson(String name, int age) {
        Person person = new Person(idCounter++, name, age);
        people.add(person);
        System.out.println("Person added: " + person);
    }

    private static void readPeople() {
        if (people.isEmpty()) {
            System.out.println("No people found.");
        } else {
            for (Person person : people) {
                System.out.println(person);
            }
        }
    }

    private static void updatePerson(int id, String newName, int newAge) {
        for (Person person : people) {
            if (person.getId() == id) {
                person.setName(newName);
                person.setAge(newAge);
                System.out.println("Person updated: " + person);
                return;
            }
        }
        System.out.println("Person with ID " + id + " not found.");
    }

    private static void deletePerson(int id) {
        Person toDelete = null;
        for (Person person : people) {
            if (person.getId() == id) {
                toDelete = person;
                break;
            }
        }
        if (toDelete != null) {
            people.remove(toDelete);
            System.out.println("Person deleted: " + toDelete);
        } else {
            System.out.println("Person with ID " + id + " not found.");
        }
    }
}
