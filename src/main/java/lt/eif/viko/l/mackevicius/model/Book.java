package lt.eif.viko.l.mackevicius.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Objects;

/**
 *
 * @author Linas Mackevičius
 * @since 1.0
 */

@Entity
public class Book {

    private @Id @GeneratedValue Long id;
    private String bookName;
    private String author;
    private String year_of_publication;
    private String publisher;
    private Double price;

    public Book(){};

    public Book(Long id, String bookName, String author, String year_of_publication, String publisher, Double price) {
        this.id = id;
        this.bookName = bookName;
        this.author = author;
        this.year_of_publication = year_of_publication;
        this.publisher = publisher;
        this.price = price;
    }

    public Book(String bookName, String author, String year_of_publication, String publisher, Double price) {
        this.bookName = bookName;
        this.author = author;
        this.year_of_publication = year_of_publication;
        this.publisher = publisher;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getYear() {
        return year_of_publication;
    }

    public void setYear(String year_of_publication) {
        this.year_of_publication = year_of_publication;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if (!(o instanceof Book)){
            return false;
        }
        Book book = (Book) o;
        return Objects.equals(this.id, book.id)
                && Objects.equals(this.author, book.author)
                && Objects.equals(this.bookName, book.bookName)
                && Objects.equals(this.price, book.price)
                && Objects.equals(this.year_of_publication, book.year_of_publication)
                && Objects.equals(this.publisher, book.publisher);
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.id, this.author, this.bookName, this.price, this.year_of_publication, this.publisher);
    }

    @Override
    public String toString() {
        return String.format("\tTrip:\n\t\t\t\t" + "Organization author = %s\n\t\t\t\t" + "author = %s\n\t\t\t\t" +
                "year_of_publication = %s\n\t\t\t\t" + "Trip Duration = %s\n\t\t\t\t" + "price = %s\n\t\t\t\t",
                this.bookName,
                this.author,
                this.year_of_publication,
                this.publisher,
                this.price);
    }

}
