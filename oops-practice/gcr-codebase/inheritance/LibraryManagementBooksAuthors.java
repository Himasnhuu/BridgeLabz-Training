package week2.oops.inheritence;

/*Sample Problem 1: Library Management with Books and Authors
Description: Model a Book system where Book is the superclass, and Author is a subclass.
Tasks:
Define a superclass Book with attributes like title and publicationYear.
Define a subclass Author with additional attributes like name and bio.
Create a method displayInfo() to show details of the book and its author.
Goal: Practice single inheritance by extending the base class and adding more
 specific details in the subclass.*/

class Book {
	protected String title;
	protected int publicationYear;

	public Book(String title, int publicationYear) {
		this.title = title;
		this.publicationYear = publicationYear;
	}

	public void displayInfo() {
		System.out.println("Title: " + title);
		System.out.println("Publication Year: " + publicationYear);
	}
}

//Author.java (Subclass)

class Author extends Book {
	private String name;
	private String bio;

	public Author(String title, int publicationYear, String name, String bio) {
		super(title, publicationYear);
		this.name = name;
		this.bio = bio;
	}

	@Override
	public void displayInfo() {
		super.displayInfo();
		System.out.println("Author: " + name);
		System.out.println("Bio: " + bio);
	}

}

public class LibraryManagementBooksAuthors {
	public static void main(String[] args) {
		Author author = new Author("Effective Java", 2018, "Joshua Bloch", "Chief Java Architect at Google");
		author.displayInfo();

	}
}
