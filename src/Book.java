public class Book {
    String author;
    String title;

    public Book ( String author, String title) {
        this.author = author;
        this.title = title;
    }

    public int hashCode() {

        return author.hashCode() + title.hashCode();
    }
    public boolean equals(Object o) {
        Book b = (Book)o;
        if (b.getAuthor().equals(author)&&b.getTitle().equals(title)) {
            return true;
        } else { return false;
        }

    }
    public String getAuthor() {
        return this.author;
    }
    public String getTitle() {
        return this.title;
    }
    public String toString() {
        return author + ", " + title;
    }

}
