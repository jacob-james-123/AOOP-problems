package tasks.Task5;
import java.util.*;
public class t3 {
    // Main class to demonstrate SOLID principles in action

    public static void main(String[] args) {
        // Create books
        Book book1 = new PhysicalBook("1984", "George Orwell");
        @SuppressWarnings("unused")
        Book book2 = new DigitalBook("Digital Fortress", "Dan Brown");

        // Create members
        Member member1 = new Member("Alice");
        Member member2 = new Member("Bob");

        // Borrowing process
        BorrowManager borrowManager = new BorrowManager();

        // Alice borrows a book
        borrowManager.borrowBook(member1, book1);
        
        // Bob tries to borrow the same book (shouldn't be allowed)
        borrowManager.borrowBook(member2, book1);

        // Alice returns the book
        borrowManager.returnBook(member1, book1);

        // Bob borrows the book after it's returned
        borrowManager.borrowBook(member2, book1);
    }
}

// 1. SRP: Class for managing book details
class Book {
    private String title;
    private String author;
    private boolean isAvailable;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isAvailable = true; // All books are available by default
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

    public void setAvailability(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
}

// OCP & LSP: Subtypes of books can be created
class PhysicalBook extends Book {
    public PhysicalBook(String title, String author) {
        super(title, author);
    }
}

class DigitalBook extends Book {
    public DigitalBook(String title, String author) {
        super(title, author);
    }
}

// SRP: Class for managing member details
class Member {
    private String name;
    private List<Book> borrowedBooks;

    public Member(String name) {
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }
}

// ISP: Segregated interfaces for borrowable and returnable actions
interface Borrowable {
    void borrowBook(Member member, Book book);
}

interface Returnable {
    void returnBook(Member member, Book book);
}

// DIP: BorrowManager depends on abstraction (Borrowable & Returnable interfaces)
class BorrowManager implements Borrowable, Returnable {
    
    @Override
    public void borrowBook(Member member, Book book) {
        if (book.isAvailable()) {
            member.borrowBook(book);
            book.setAvailability(false);
            System.out.println(member.getName() + " borrowed the book: " + book.getTitle());
        } else {
            System.out.println("Book is not available.");
        }
    }

    @Override
    public void returnBook(Member member, Book book) {
        if (member.getBorrowedBooks().contains(book)) {
            member.returnBook(book);
            book.setAvailability(true);
            System.out.println(member.getName() + " returned the book: " + book.getTitle());
        } else {
            System.out.println(member.getName() + " hasn't borrowed this book.");
        }
    }
}


