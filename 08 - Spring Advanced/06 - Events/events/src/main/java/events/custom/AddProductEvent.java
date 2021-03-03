package events.custom;

import org.springframework.context.ApplicationEvent;

public class AddProductEvent extends ApplicationEvent {

    private final String message;

    public AddProductEvent(Object source, String message) {
        super(source);
        this.message = message;
    }

    public String getMessage(){
        return message;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AddProductEvent{");
        sb.append("message='").append(message).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
