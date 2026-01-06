package scenariobased.oops;

import java.util.ArrayList;
import java.util.Scanner;

// Custom Exception
class BookNotAvailableException extends Exception {
    public BookNotAvailableException(String message) {
        super(message);
    }
}

// Book class
class Book {
    String title;
    String author;
    String status; // "Available" or "Checked Out"
    
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.status = "Available";
    }
    
    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", Status: " + status;
    }
}

public class LibraryManagementSystem {
    
    static ArrayList<Book> books = new ArrayList<>();
    
    // Search book by partial title
    public static void searchBook(String searchTitle) {
        boolean found = false;
        System.out.println("\nSearch Results:");
        
        for (Book book : books) {
            if (book.title.toLowerCase().contains(searchTitle.toLowerCase())) {
                System.out.println(book);
                found = true;
            }
        }
        
        if (!found) {
            System.out.println("No books found!");
        }
    }
    
    // Display all books
    public static void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in library.");
            return;
        }
        
        System.out.println("\n=== All Books ===");
        for (int i = 0; i < books.size(); i++) {
            System.out.println((i + 1) + ". " + books.get(i));
        }
    }
    
    // Checkout book
    public static void checkoutBook(String title) throws BookNotAvailableException {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title)) {
                if (book.status.equals("Available")) {
                    book.status = "Checked Out";
                    System.out.println("✓ Book checked out successfully!");
                    return;
                } else {
                    throw new BookNotAvailableException("Book is already checked out!");
                }
            }
        }
        throw new BookNotAvailableException("Book not found in library!");
    }
    
    // Return book
    public static void returnBook(String title) {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title)) {
                if (book.status.equals("Checked Out")) {
                    book.status = "Available";
                    System.out.println("✓ Book returned successfully!");
                    return;
                } else {
                    System.out.println("This book was not checked out.");
                    return;
                }
            }
        }
        System.out.println("Book not found!");
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Add some books
        books.add(new Book("Java Programming", "John Smith"));
        books.add(new Book("Data Structures", "Alice Brown"));
        books.add(new Book("Python Basics", "Bob Johnson"));
        
        while (true) {
            System.out.println("\n=== Library Management ===");
            System.out.println("1. Display All Books");
            System.out.println("2. Search Book");
            System.out.println("3. Checkout Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Choose: ");
            
            int choice = sc.nextInt();
            sc.nextLine();
            
            try {
                switch (choice) {
                    case 1:
                        displayBooks();
                        break;
                        
                    case 2:
                        System.out.print("Enter title to search: ");
                        String searchTitle = sc.nextLine();
                        searchBook(searchTitle);
                        break;
                        
                    case 3:
                        System.out.print("Enter book title to checkout: ");
                        String checkoutTitle = sc.nextLine();
                        checkoutBook(checkoutTitle);
                        break;
                        
                    case 4:
                        System.out.print("Enter book title to return: ");
                        String returnTitle = sc.nextLine();
                        returnBook(returnTitle);
                        break;
                        
                    case 5:
                        System.out.println("Goodbye!");
                        sc.close();
                        return;
                        
                    default:
                        System.out.println("Invalid choice!");
                }
            } catch (BookNotAvailableException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
