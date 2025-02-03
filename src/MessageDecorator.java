public abstract class MessageDecorator implements Message {
    protected Message component;

    public MessageDecorator(Message component) {
        this.component = component;
    }

    @Override
    public String getMessage() {
        return component.getMessage();
    }
}
