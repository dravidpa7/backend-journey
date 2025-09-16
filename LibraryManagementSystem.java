import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// ============================================================================
// LIBRARY MANAGEMENT SYSTEM - DEMONSTRATING JAVA CONCEPTS
// ============================================================================

/**
 * INHERITANCE & ABSTRACT CLASSES
 * Abstract base class representing any item in the library
 * Real-world use: Different types of media (books, DVDs, magazines) share common properties
 */
abstract class LibraryItem {
    protected String id;
    protected String title;
    protected boolean isAvailable;
    protected LocalDate dateAdded;
    
    // CONSTRUCTOR
    public LibraryItem(String id, String title) {
        this.id = id;
        this.title = title;
        this.isAvailable = true;
        this.dateAdded = LocalDate.now();
    }
    
    // ABSTRACT METHOD - Forces subclasses to implement their own version
    public abstract String getItemType();
    public abstract double getLateFee();
    
    // ENCAPSULATION - Getter and Setter methods to control access to private fields
    public String getId() { return id; }
    public String getTitle() { return title; }
    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { this.isAvailable = available; }
    
    // METHOD OVERRIDING will happen in subclasses
    public String getInfo() {
        return String.format("ID: %s, Title: %s, Available: %s", id, title, isAvailable);
    }
}

/**
 * INHERITANCE - Book extends LibraryItem
 * Real-world use: Books are a specific type of library item with additional properties
 */
class Book extends LibraryItem {
    private String author;
    private String isbn;
    private int pages;
    
    public Book(String id, String title, String author, String isbn, int pages) {
        super(id, title); // Calling parent constructor
        this.author = author;
        this.isbn = isbn;
        this.pages = pages;
    }
    
    // POLYMORPHISM - Different implementation of abstract methods
    @Override
    public String getItemType() {
        return "Book";
    }
    
    @Override
    public double getLateFee() {
        return 0.50; // Books have $0.50 per day late fee
    }
    
    // METHOD OVERRIDING - Providing specific implementation
    @Override
    public String getInfo() {
        return super.getInfo() + String.format(", Author: %s, ISBN: %s, Pages: %d", 
               author, isbn, pages);
    }
    
    // ENCAPSULATION
    public String getAuthor() { return author; }
    public String getIsbn() { return isbn; }
}

/**
 * INHERITANCE - DVD extends LibraryItem
 */
class DVD extends LibraryItem {
    private String director;
    private int duration; // in minutes
    
    public DVD(String id, String title, String director, int duration) {
        super(id, title);
        this.director = director;
        this.duration = duration;
    }
    
    @Override
    public String getItemType() {
        return "DVD";
    }
    
    @Override
    public double getLateFee() {
        return 1.00; // DVDs have $1.00 per day late fee
    }
    
    @Override
    public String getInfo() {
        return super.getInfo() + String.format(", Director: %s, Duration: %d mins", 
               director, duration);
    }
}

/**
 * COMPOSITION - Member class contains other objects
 * Real-world use: A library member has personal info and a list of borrowed items
 */
class Member {
    private String memberId;
    private String name;
    private String email;
    private List<LibraryItem> borrowedItems; // COMPOSITION - Member "has-a" list of items
    private LocalDate memberSince;
    
    public Member(String memberId, String name, String email) {
        this.memberId = memberId;
        this.name = name;
        this.email = email;
        this.borrowedItems = new ArrayList<>(); // COLLECTIONS FRAMEWORK
        this.memberSince = LocalDate.now();
    }
    
    public void borrowItem(LibraryItem item) {
        if (item.isAvailable()) {
            borrowedItems.add(item);
            item.setAvailable(false);
            System.out.println(name + " borrowed: " + item.getTitle());
        } else {
            System.out.println("Item not available: " + item.getTitle());
        }
    }
    
    public void returnItem(LibraryItem item) {
        if (borrowedItems.remove(item)) {
            item.setAvailable(true);
            System.out.println(name + " returned: " + item.getTitle());
        } else {
            System.out.println("Item was not borrowed by this member: " + item.getTitle());
        }
    }
    
    // ENCAPSULATION
    public String getMemberId() { return memberId; }
    public String getName() { return name; }
    public List<LibraryItem> getBorrowedItems() { return new ArrayList<>(borrowedItems); }
}

/**
 * INTERFACE - Defines a contract for search functionality
 * Real-world use: Different search strategies can implement this interface
 */
interface Searchable {
    List<LibraryItem> search(String query);
}

/**
 * AGGREGATION - Library class uses LibraryItem and Member objects
 * Real-world use: A library manages collections of items and members
 */
class Library implements Searchable {
    private String name;
    private Map<String, LibraryItem> items; // COLLECTIONS FRAMEWORK - HashMap for fast lookup
    private Map<String, Member> members;    // Key-value storage
    private Scanner scanner;
    
    public Library(String name) {
        this.name = name;
        this.items = new HashMap<>();
        this.members = new HashMap<>();
        this.scanner = new Scanner(System.in);
    }
    
    public void addItem(LibraryItem item) {
        items.put(item.getId(), item);
        System.out.println("Added " + item.getItemType() + ": " + item.getTitle());
    }
    
    public void addMember(Member member) {
        members.put(member.getMemberId(), member);
        System.out.println("Added member: " + member.getName());
    }
    
    // INTERFACE IMPLEMENTATION
    @Override
    public List<LibraryItem> search(String query) {
        List<LibraryItem> results = new ArrayList<>();
        query = query.toLowerCase();
        
        // ENHANCED FOR LOOP (for-each) - Java 5 feature
        for (LibraryItem item : items.values()) {
            if (item.getTitle().toLowerCase().contains(query)) {
                results.add(item);
            }
        }
        return results;
    }
    
    // EXCEPTION HANDLING
    public LibraryItem findItem(String id) {
        try {
            LibraryItem item = items.get(id);
            if (item == null) {
                throw new IllegalArgumentException("Item not found with ID: " + id);
            }
            return item;
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }
    
    public Member findMember(String memberId) {
        return members.get(memberId);
    }
    
    // METHOD OVERLOADING - Same method name, different parameters
    public void displayItems() {
        displayItems(true); // Show all items by default
    }
    
    public void displayItems(boolean showAvailableOnly) {
        System.out.println("\n=== Library Items ===");
        for (LibraryItem item : items.values()) {
            if (!showAvailableOnly || item.isAvailable()) {
                System.out.println(item.getInfo());
            }
        }
    }
    
    // STATIC METHOD - Utility method that belongs to the class, not instance
    public static void printSeparator() {
        System.out.println("=" .repeat(50));
    }
    
    // Interactive menu system
    public void runLibrarySystem() {
        initializeSampleData(); // Add some sample data
        
        while (true) {
            showMainMenu();
            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // consume newline
                
                switch (choice) {
                    case 1 -> displayItems();
                    case 2 -> searchItems();
                    case 3 -> borrowItem();
                    case 4 -> returnItem();
                    case 5 -> addNewMember();
                    case 6 -> showMemberInfo();
                    case 0 -> {
                        System.out.println("Thank you for using " + name + "!");
                        return;
                    }
                    default -> System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number.");
                scanner.nextLine(); // clear invalid input
            }
        }
    }
    
    private void showMainMenu() {
        printSeparator();
        System.out.println("Welcome to " + name);
        System.out.println("1. View all items");
        System.out.println("2. Search items");
        System.out.println("3. Borrow item");
        System.out.println("4. Return item");
        System.out.println("5. Add new member");
        System.out.println("6. Member information");
        System.out.println("0. Exit");
        System.out.print("Choose an option: ");
    }
    
    private void searchItems() {
        System.out.print("Enter search term: ");
        String query = scanner.nextLine();
        List<LibraryItem> results = search(query);
        
        if (results.isEmpty()) {
            System.out.println("No items found matching: " + query);
        } else {
            System.out.println("\nSearch Results:");
            results.forEach(item -> System.out.println(item.getInfo())); // LAMBDA EXPRESSION
        }
    }
    
    private void borrowItem() {
        System.out.print("Enter member ID: ");
        String memberId = scanner.nextLine();
        Member member = findMember(memberId);
        
        if (member == null) {
            System.out.println("Member not found!");
            return;
        }
        
        System.out.print("Enter item ID: ");
        String itemId = scanner.nextLine();
        LibraryItem item = findItem(itemId);
        
        if (item != null) {
            member.borrowItem(item);
        }
    }
    
    private void returnItem() {
        System.out.print("Enter member ID: ");
        String memberId = scanner.nextLine();
        Member member = findMember(memberId);
        
        if (member == null) {
            System.out.println("Member not found!");
            return;
        }
        
        if (member.getBorrowedItems().isEmpty()) {
            System.out.println(member.getName() + " has no borrowed items.");
            return;
        }
        
        System.out.println("Borrowed items:");
        List<LibraryItem> borrowed = member.getBorrowedItems();
        for (int i = 0; i < borrowed.size(); i++) {
            System.out.println((i + 1) + ". " + borrowed.get(i).getTitle());
        }
        
        System.out.print("Select item to return (number): ");
        try {
            int choice = scanner.nextInt() - 1;
            scanner.nextLine();
            
            if (choice >= 0 && choice < borrowed.size()) {
                member.returnItem(borrowed.get(choice));
            } else {
                System.out.println("Invalid selection.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Please enter a valid number.");
            scanner.nextLine();
        }
    }
    
    private void addNewMember() {
        System.out.print("Enter member ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        
        Member newMember = new Member(id, name, email);
        addMember(newMember);
    }
    
    private void showMemberInfo() {
        System.out.print("Enter member ID: ");
        String memberId = scanner.nextLine();
        Member member = findMember(memberId);
        
        if (member == null) {
            System.out.println("Member not found!");
            return;
        }
        
        System.out.println("\n=== Member Information ===");
        System.out.println("ID: " + member.getMemberId());
        System.out.println("Name: " + member.getName());
        System.out.println("Borrowed items: " + member.getBorrowedItems().size());
        
        if (!member.getBorrowedItems().isEmpty()) {
            System.out.println("\nCurrently borrowed:");
            member.getBorrowedItems().forEach(item -> 
                System.out.println("- " + item.getTitle() + " (" + item.getItemType() + ")")
            );
        }
    }
    
    // Initialize with sample data for demonstration
    private void initializeSampleData() {
        // Add sample books
        addItem(new Book("B001", "The Great Gatsby", "F. Scott Fitzgerald", "978-0-7432-7356-5", 180));
        addItem(new Book("B002", "To Kill a Mockingbird", "Harper Lee", "978-0-06-112008-4", 281));
        addItem(new Book("B003", "1984", "George Orwell", "978-0-452-28423-4", 328));
        
        // Add sample DVDs
        addItem(new DVD("D001", "The Shawshank Redemption", "Frank Darabont", 142));
        addItem(new DVD("D002", "Pulp Fiction", "Quentin Tarantino", 154));
        
        // Add sample members
        addMember(new Member("M001", "John Doe", "john.doe@email.com"));
        addMember(new Member("M002", "Jane Smith", "jane.smith@email.com"));
        
        System.out.println("Sample data initialized!");
    }
}

// ============================================================================
// MAIN CLASS - ENTRY POINT
// ============================================================================
public class LibraryManagementSystem {
    // STATIC METHOD - Entry point of Java application
    public static void main(String[] args) {
        System.out.println("Starting Library Management System...");
        System.out.println("This demo showcases key Java concepts in a real-world scenario.\n");
        
        // OBJECT INSTANTIATION
        Library library = new Library("Central City Library");
        
        // Run the interactive system
        library.runLibrarySystem();
    }
}

/* 
=============================================================================
JAVA CONCEPTS DEMONSTRATED:

1. OBJECT-ORIENTED PROGRAMMING (OOP):
   - Classes and Objects: LibraryItem, Book, DVD, Member, Library
   - Encapsulation: Private fields with public getters/setters
   - Inheritance: Book and DVD extend LibraryItem
   - Polymorphism: Different implementations of abstract methods
   - Abstraction: Abstract LibraryItem class

2. COLLECTIONS FRAMEWORK:
   - ArrayList: For storing borrowed items and search results
   - HashMap: For fast lookup of items and members by ID
   - Enhanced for loops (for-each)

3. EXCEPTION HANDLING:
   - try-catch blocks for error management
   - Custom exception throwing
   - InputMismatchException handling

4. INTERFACES:
   - Searchable interface for search functionality

5. STATIC METHODS:
   - main() method as entry point
   - Utility methods that belong to class, not instance

6. METHOD OVERLOADING:
   - Multiple displayItems() methods with different parameters

7. COMPOSITION VS INHERITANCE:
   - Member "has-a" list of LibraryItem (composition)
   - Book "is-a" LibraryItem (inheritance)

8. LAMBDA EXPRESSIONS (Java 8+):
   - forEach with lambda for cleaner iteration

9. DATE/TIME API (Java 8+):
   - LocalDate for tracking dates

10. INPUT/OUTPUT:
    - Scanner for user input
    - System.out for output

REAL-WORLD APPLICATIONS:
- Library systems actually use these concepts
- Inheritance allows different media types with shared properties
- Collections provide efficient data storage and retrieval
- Exception handling ensures robust user experience
- Interfaces allow for flexible, expandable design
- Encapsulation protects data integrity
=============================================================================
*/