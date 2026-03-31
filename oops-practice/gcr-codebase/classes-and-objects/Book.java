// 3. Program to Handle Book Details
package week2.oops.classesAndObject;

public class Book {
    
    // attributes
    String title;
    String author;
    double price;
    
    // method to display book details
    void displayBookDetails() {
        System.out.println("Title of the book: " + title);
        System.out.println("Author of the book: " + author);
        System.out.println("Price of the book: " + price);
    }
    
    public static void main(String[] args) {
        
        // create first book object
        Book book1 = new Book();
        book1.title = "2States";
        book1.author = "Chetan Bhagat";
        book1.price = 500.0;
        
        // display first book details
        book1.displayBookDetails();
        
        // create second book object
        Book book2 = new Book();
        book2.title = "Wings Of Fire";
        book2.author = "Abdul kalam.A.P.J";
        book2.price = 500.0;
        
        // display second book details
        book2.displayBookDetails();
    }
}
