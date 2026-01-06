package week2.oops.encapsulation;

/*5. Library Management System
Description: Develop a library management system:
Use an abstract class LibraryItem with fields like itemId, title, and author.
Add an abstract method getLoanDuration() and a concrete method getItemDetails().
Create subclasses Book, Magazine, and DVD, overriding getLoanDuration() with specific logic.
Implement an interface Reservable with methods reserveItem() and checkAvailability().
Apply encapsulation to secure details like the borrower's personal data.
Use polymorphism to allow a general LibraryItem reference to manage all items, regardless of type.*/

// Interface Reservable
interface Reservable {
    void reserveItem(String borrowerName);
    boolean checkAvailability();
}

// Abstract class LibraryItem
abstract class LibraryItem {
    private String itemId;
    private String title;
    private String author;
    private boolean isAvailable;
    private String borrowerName;
    private String borrowerContact;
    
    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }
    
    public abstract int getLoanDuration();
    
    public void getItemDetails() {
        System.out.println("Item ID: " + itemId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Available: " + (isAvailable ? "Yes" : "No"));
        if (!isAvailable) {
            System.out.println("Borrowed by: " + getBorrowerInitials());
        }
    }
    
    // Encapsulated method - only shows initials
    private String getBorrowerInitials() {
        if (borrowerName != null && !borrowerName.isEmpty()) {
            String[] parts = borrowerName.split(" ");
            StringBuilder initials = new StringBuilder();
            for (String part : parts) {
                initials.append(part.charAt(0)).append(".");
            }
            return initials.toString();
        }
        return "N/A";
    }
    
    // Getters and Setters (Encapsulation)
    public String getItemId() {
        return itemId;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public boolean isAvailable() {
        return isAvailable;
    }
    
    protected void setAvailable(boolean available) {
        isAvailable = available;
    }
    
    protected void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }
    
    protected void setBorrowerContact(String borrowerContact) {
        this.borrowerContact = borrowerContact;
    }
}

// Book class
class Book extends LibraryItem implements Reservable {
    private String isbn;
    
    public Book(String itemId, String title, String author, String isbn) {
        super(itemId, title, author);
        this.isbn = isbn;
    }
    
    @Override
    public int getLoanDuration() {
        return 14; // 14 days for books
    }
    
    @Override
    public void reserveItem(String borrowerName) {
        if (checkAvailability()) {
            setAvailable(false);
            setBorrowerName(borrowerName);
            System.out.println("Book '" + getTitle() + "' reserved successfully");
            System.out.println("Loan Duration: " + getLoanDuration() + " days");
        } else {
            System.out.println("Book is currently unavailable");
        }
    }
    
    @Override
    public boolean checkAvailability() {
        return isAvailable();
    }
    
    @Override
    public void getItemDetails() {
        System.out.println("\n--- Book Details ---");
        super.getItemDetails();
        System.out.println("ISBN: " + isbn);
        System.out.println("Loan Duration: " + getLoanDuration() + " days");
    }
}

// Magazine class
class Magazine extends LibraryItem implements Reservable {
    private String issueNumber;
    
    public Magazine(String itemId, String title, String author, String issueNumber) {
        super(itemId, title, author);
        this.issueNumber = issueNumber;
    }
    
    @Override
    public int getLoanDuration() {
        return 7; // 7 days for magazines
    }
    
    @Override
    public void reserveItem(String borrowerName) {
        if (checkAvailability()) {
            setAvailable(false);
            setBorrowerName(borrowerName);
            System.out.println("Magazine '" + getTitle() + "' reserved successfully");
            System.out.println("Loan Duration: " + getLoanDuration() + " days");
        } else {
            System.out.println("Magazine is currently unavailable");
        }
    }
    
    @Override
    public boolean checkAvailability() {
        return isAvailable();
    }
    
    @Override
    public void getItemDetails() {
        System.out.println("\n--- Magazine Details ---");
        super.getItemDetails();
        System.out.println("Issue Number: " + issueNumber);
        System.out.println("Loan Duration: " + getLoanDuration() + " days");
    }
}

// DVD class
class DVD extends LibraryItem implements Reservable {
    private String duration;
    
    public DVD(String itemId, String title, String author, String duration) {
        super(itemId, title, author);
        this.duration = duration;
    }
    
    @Override
    public int getLoanDuration() {
        return 3; // 3 days for DVDs
    }
    
    @Override
    public void reserveItem(String borrowerName) {
        if (checkAvailability()) {
            setAvailable(false);
            setBorrowerName(borrowerName);
            System.out.println("DVD '" + getTitle() + "' reserved successfully");
            System.out.println("Loan Duration: " + getLoanDuration() + " days");
        } else {
            System.out.println("DVD is currently unavailable");
        }
    }
    
    @Override
    public boolean checkAvailability() {
        return isAvailable();
    }
    
    @Override
    public void getItemDetails() {
        System.out.println("\n--- DVD Details ---");
        super.getItemDetails();
        System.out.println("Duration: " + duration);
        System.out.println("Loan Duration: " + getLoanDuration() + " days");
    }
}

// Main class
public class LibraryManagementSystem {
    
    public static void main(String[] args) {
        // Create library items
        Book book = new Book("B001", "Effective Java", "Joshua Bloch", "978-0134685991");
        Magazine magazine = new Magazine("M001", "National Geographic", "Various", "Jan 2026");
        DVD dvd = new DVD("D001", "Inception", "Christopher Nolan", "148 min");
        
        System.out.println("========== LIBRARY MANAGEMENT SYSTEM ==========");
        
        // Display all items
        book.getItemDetails();
        magazine.getItemDetails();
        dvd.getItemDetails();
        
        // Reserve items
        System.out.println("\n========== RESERVATION ==========");
        book.reserveItem("John Smith");
        magazine.reserveItem("Alice Johnson");
        dvd.reserveItem("Bob Williams");
        
        // Try to reserve again
        System.out.println("\n========== DUPLICATE RESERVATION ==========");
        book.reserveItem("Jane Doe");
        
        // Display updated details
        System.out.println("\n========== UPDATED LIBRARY STATUS ==========");
        book.getItemDetails();
        
        // Polymorphism demonstration
        System.out.println("\n========== POLYMORPHISM DEMO ==========");
        LibraryItem[] items = {book, magazine, dvd};
        
        System.out.println("\nAll Library Items:");
        for (LibraryItem item : items) {
            item.getItemDetails();
        }
        
        // Check availability polymorphically
        System.out.println("\n========== AVAILABILITY CHECK ==========");
        for (LibraryItem item : items) {
            if (item instanceof Reservable) {
                System.out.println(item.getTitle() + " - Available: " + 
                                 ((Reservable) item).checkAvailability());
            }
        }
    }
}
