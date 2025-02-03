import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BasicMessage implements Message {
    @Override
    public String getMessage() {
        String day = LocalDate.now().getDayOfWeek().toString();
        String date = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        return "Day: " +day  +  " \n   Date:  " + date;
    }
}
