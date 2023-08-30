package lt.eif.viko.l.mackevicius.model;


import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author Linas Mackevičius
 * @since 1.0
 */
@Entity
public class Order extends Book {

    private @Id @GeneratedValue Long id;
    private String orderDate;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Customer> customers;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Book> books;

    public Order(){};

    public Order(Long id, String orderDate, List<Customer> customers, List<Book> books) {
        this.id = id;
        this.orderDate = orderDate;
        this.customers = customers;
        this.books = books;
    }

    public Order(String orderDate, List<Customer> customers, List<Book> books) {
        this.orderDate = orderDate;
        this.customers = customers;
        this.books = books;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public boolean equals(Object o){
        if (this == o){
            return true;
        }

        if(!(o instanceof Order)){
            return false;
        }

        Order order = (Order) o;
        return Objects.equals(this.id, order.id)
                && Objects.equals(this.orderDate, order.orderDate)
                && Objects.equals(this.books, order.books)
                && Objects.equals(this.customers, order.customers);
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.id, this.orderDate, this.books, this.customers);
    }

    @Override
    public String toString() {
        return String.format("Order:\n\t Date = %s\n\t" +
                        "Customers: \n\t%s" +
                        "Books:\n\t\t%s",
                this.orderDate,
                this.customers,
                this.books,
                constructCustomerString(),
                constructBookString());
    }

   private String constructCustomerString(){
        String resultCustomer = "";
        for(Customer customer : this.customers){
            resultCustomer += customer.toString();
        }
        return resultCustomer;
    }
    private String constructBookString(){
        String resultBook = "";
        for(Book book : this.books){
            resultBook += book.toString();
        }
        return resultBook;
    }
}
