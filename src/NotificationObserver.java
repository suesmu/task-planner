
import javax.swing.JTextArea;
import java.util.List;

public class NotificationObserver implements Observer {
    private JTextArea notificationsArea;

    public NotificationObserver(JTextArea notificationsArea) {
        this.notificationsArea = notificationsArea;
    }

    @Override
    public void update(List<String> notifications) {
        notificationsArea.setText("");
        for (String notification : notifications) {
            notificationsArea.append(notification + "\n");

        }

    }
}

