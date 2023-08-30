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
public class Customer {

    private @Id @GeneratedValue Long id;
    private String firstName;
    private String lastName;


    public Customer(){}

    public Customer(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(!(o instanceof Customer)){
            return false;
        }
        Customer customer = (Customer) o;
        return Objects.equals(this.id, customer.id)
                && Objects.equals(this.firstName, customer.firstName)
                && Objects.equals(this.lastName, customer.lastName);
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.id, this.firstName, this.lastName);
    }

    @Override
    public String toString(){
        return String.format("\tName = %s\n\t\t" + "Last Name = %s\n\t\t",
                this.firstName,
                this.lastName);
    }
}
