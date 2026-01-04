package scenariobased;

/*Library Management System – Book Search and Checkout
Scenario: You’re designing a system for a small library to manage books and track checkouts.
Problem Requirements:
● Store book details (title, author, status) in a Array.
● Allow searching by partial title using String operations.
● Store book data in an Array.
● Use methods for searching, displaying, and updating book status (checked out or
available).*/


class Books{
	String title;
	String author;
	//status for availability 
	String status;
	
	Books(String title, String author, String status){
		this.author=author;
		this.title=title;
		this.status=status;
	}
}

///library class
class Library{
	Books[] books;
	
	Library(Books[] book){
		this.books=book;
	}
	
	//display all books 
	void displayBook(){
		for(Books book:books) {
			System.out.println("Title : "+book.title+
								"Author : "+book.author+
								"Status : "+book.status);
		}
	}
	
	//search by partial title 
	void searchByTitle(String serTxt) {
		for(Books book:books) {
			if(book.title.toLowerCase().contains(serTxt.toLowerCase())) {
				System.out.println("Found -> Title: " + book.title + ", Author: " + book.author + ", Status: " + book.status);
			}
		}
		
	}
	
	//update book status
	void updateBookStatus(String title){
		for(Books book:books) {
			if(book.title.equalsIgnoreCase(title) && book.status.equals("Available")) {
				book.status = "Checked Out";
                System.out.println("Book Checked Out: " + book.title);
                return;
			}
		}
		
		 System.out.println("Book not available for checkout");
	}
	
}


public class LibraryManagementSystem {

	public static void main(String[] args) {
		
		Books[] bookArray = new Books[3];
        bookArray[0] = new Books("Cyber Security", "Pt HariDas", "Available");
        bookArray[1] = new Books("Spring Boot Guide", "james Gosling", "Available");
        bookArray[2] = new Books("Data Structures", "Allen turing", "Checked Out");

        Library library=new Library(bookArray);
        //testing all operations
        library.displayBook();
        library.searchByTitle("Cyber security");
        library.updateBookStatus("Spring Boot Guide");
        library.displayBook();
	}

}