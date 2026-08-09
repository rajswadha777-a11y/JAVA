class LibraryBook {

    final String isbn;
    String title;
    String author;
    double price;

    LibraryBook(String isbn, String title, String author, double price) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    void display() {
        System.out.println("ISBN: " + isbn);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: Rs. " + price);
    }
}

public class LibraryBookDisplay {

    public static void main(String[] args) {

        LibraryBook book =
            new LibraryBook("9780134685991",
                            "Java Programming",
                            "Herbert Schildt",
                            800);

        book.display();

        // book.isbn = "123456";   // Error: final cannot be changed
    }
}