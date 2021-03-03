package events.custom;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class AddProductListener {

    @EventListener(AddProductEvent.class)
    public void onProductAdded(AddProductEvent productEvent){

        //TODO notify the users
        //TODO count the products
        //TODO ....
        System.out.println(productEvent);
    }
}
