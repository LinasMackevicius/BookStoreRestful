package lt.eif.viko.l.mackevicius.exception;

public class OrderNotFoundException extends RuntimeException{

    public OrderNotFoundException(Long id){
        super("Order Could not be found " + id);
    }
}
