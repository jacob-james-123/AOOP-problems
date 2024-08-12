import java.util.ArrayList;
import java.util.Scanner;


// Main Class
public class LibraryManagementSystem {
    public static void main(String[] args) {
        LibraryManagement library = new LibraryManagement();
        Scanner scanner = new Scanner(System.in);

        // Example interactions
        library.addBook("cse", new Book("Data Structures", "Seymour Lipschutz", 10));
        library.addBook("ece", new Book("Digital Logic Design", "M. Morris Mano", 5));
        library.addBook("csit", new Book("Introduction to Algorithms", "Thomas H. Cormen", 7));

        library.searchBook("cse", "Data Structures");
        library.checkCategoryNumber("cse");
        library.removeBook("cse", "Data Structures");
        library.searchBook("cse", "Data Structures");

        scanner.close();
    }
}
// Book class
class Book {
    String title;
    private String author;
    private int quantity;

    Book(String title, String author, int q) {
        this.title = title;
        this.author = author;
        this.quantity = q;
    }

    public String getAuthor() {
        return author;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

// Interface for categories
interface Categories {
    void searchBook(String title);
    void addBook(Book book);
    void removeBook(String title);
    void checkNumber();
}

// CSE Category
class CSE implements Categories {
    ArrayList<Book> cseBooks = new ArrayList<>();

    public void searchBook(String title) {
        for (Book b : cseBooks) {
            if (b.title.equalsIgnoreCase(title)) {
                System.out.println("Book found: " + b.title + " by " + b.getAuthor());
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void addBook(Book book) {
        cseBooks.add(book);
        System.out.println("Book added to CSE category.");
    }

    public void removeBook(String title) {
        for (Book b : cseBooks) {
            if (b.title.equalsIgnoreCase(title)) {
                cseBooks.remove(b);
                System.out.println("Book removed from CSE category.");
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void checkNumber() {
        System.out.println("Number of books in CSE category: " + cseBooks.size());
    }
}

// ECE Category
class ECE implements Categories {
    ArrayList<Book> eceBooks = new ArrayList<>();

    public void searchBook(String title) {
        for (Book b : eceBooks) {
            if (b.title.equalsIgnoreCase(title)) {
                System.out.println("Book found: " + b.title + " by " + b.getAuthor());
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void addBook(Book book) {
        eceBooks.add(book);
        System.out.println("Book added to ECE category.");
    }

    public void removeBook(String title) {
        for (Book b : eceBooks) {
            if (b.title.equalsIgnoreCase(title)) {
                eceBooks.remove(b);
                System.out.println("Book removed from ECE category.");
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void checkNumber() {
        System.out.println("Number of books in ECE category: " + eceBooks.size());
    }
}

// CSIT Category
class CSIT implements Categories {
    ArrayList<Book> csitBooks = new ArrayList<>();

    public void searchBook(String title) {
        for (Book b : csitBooks) {
            if (b.title.equalsIgnoreCase(title)) {
                System.out.println("Book found: " + b.title + " by " + b.getAuthor());
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void addBook(Book book) {
        csitBooks.add(book);
        System.out.println("Book added to CSIT category.");
    }

    public void removeBook(String title) {
        for (Book b : csitBooks) {
            if (b.title.equalsIgnoreCase(title)) {
                csitBooks.remove(b);
                System.out.println("Book removed from CSIT category.");
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void checkNumber() {
        System.out.println("Number of books in CSIT category: " + csitBooks.size());
    }
}

// Library Management Class
class LibraryManagement {
    CSE cseCategory = new CSE();
    ECE eceCategory = new ECE();
    CSIT csitCategory = new CSIT();

    public void addBook(String category, Book book) {
        switch (category.toLowerCase()) {
            case "cse":
                cseCategory.addBook(book);
                break;
            case "ece":
                eceCategory.addBook(book);
                break;
            case "csit":
                csitCategory.addBook(book);
                break;
            default:
                System.out.println("Invalid category.");
                break;
        }
    }

    public void removeBook(String category, String title) {
        switch (category.toLowerCase()) {
            case "cse":
                cseCategory.removeBook(title);
                break;
            case "ece":
                eceCategory.removeBook(title);
                break;
            case "csit":
                csitCategory.removeBook(title);
                break;
            default:
                System.out.println("Invalid category.");
                break;
        }
    }

    public void searchBook(String category, String title) {
        switch (category.toLowerCase()) {
            case "cse":
                cseCategory.searchBook(title);
                break;
            case "ece":
                eceCategory.searchBook(title);
                break;
            case "csit":
                csitCategory.searchBook(title);
                break;
            default:
                System.out.println("Invalid category.");
                break;
        }
    }

    public void checkCategoryNumber(String category) {
        switch (category.toLowerCase()) {
            case "cse":
                cseCategory.checkNumber();
                break;
            case "ece":
                eceCategory.checkNumber();
                break;
            case "csit":
                csitCategory.checkNumber();
                break;
            default:
                System.out.println("Invalid category.");
                break;
        }
    }
}


