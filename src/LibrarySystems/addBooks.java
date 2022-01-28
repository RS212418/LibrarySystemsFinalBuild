package LibrarySystems;

public class addBooks {
    String bookTitle;
    String ISBN;
    String bookAuthor;
    String bookGenre;

    public addBooks(String bookTitle, String ISBN, String bookAuthor, String bookGenre) {
        this.bookTitle = bookTitle;
        this.ISBN = ISBN;
        this.bookAuthor = bookAuthor;
        this.bookGenre = bookGenre;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookGenre() {
        return bookGenre;
    }

    public void setBookGenre(String bookGenre) {
        this.bookGenre = bookGenre;
    }

    @Override
    public String toString() {
        return "addBooks{" +
                "bookTitle='" + bookTitle + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", bookGenre='" + bookGenre + '\'' +
                '}';
    }


}
