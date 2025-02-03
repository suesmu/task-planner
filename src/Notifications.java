import java.util.List;

public class Notifications extends MessageDecorator {
    private List<String> notifications;

    public Notifications(Message component, List<String> notifications) {
        super(component);
        this.notifications = notifications;
    }

    @Override
    public String getMessage() {
        String baseMessage = super.getMessage();
        return baseMessage;
    }
}
