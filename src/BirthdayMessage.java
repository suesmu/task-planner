import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BirthdayMessage extends MessageDecorator {
    private String birthDate;

    public BirthdayMessage(Message component, String birthDate) {
        super(component);
        this.birthDate = birthDate;
    }

    @Override
    public String getMessage() {
        String baseMessage = super.getMessage();
        String today = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        if (today.equals(birthDate)) {
            return baseMessage + ", Happy Birthday Esen \uD83C\uDF89 !";
        }
        return baseMessage;
    }
}

