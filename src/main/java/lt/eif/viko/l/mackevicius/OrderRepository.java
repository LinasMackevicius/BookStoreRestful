package lt.eif.viko.l.mackevicius;

import lt.eif.viko.l.mackevicius.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
