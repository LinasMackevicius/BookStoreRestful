package lt.eif.viko.l.mackevicius.configuration;

import lt.eif.viko.l.mackevicius.OrderRepository;
import lt.eif.viko.l.mackevicius.model.Order;
import lt.eif.viko.l.mackevicius.model.Customer;
import lt.eif.viko.l.mackevicius.model.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(OrderRepository repository){

        Book book1 = new Book("Brain Droppings", "George Carlin", "1997", "Vivaldi Prints", 15.99);
        Customer customer1 = new Customer("Bill", "Burr");
        Order order1 = new Order("2023-08-20", List.of(customer1), List.of(book1));

        Book book2 = new Book("Crime and Punishment", "Fyodor Dostoevsky", "1866", "Russian Classics Foundation", 22.22);

        Customer customer01 = new Customer("Jhonny", "Harris");

        Customer customer02 = new Customer("Joe", "Rogan");

        Order order2 = new Order("2024-04-10", List.of(customer01,customer02), List.of(book2));


        return args -> {
            log.info("Loading" + repository.save(order1));
            log.info("Loading" + repository.save(order2));
        };

    }
}
