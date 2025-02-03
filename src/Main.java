import javax.swing.*;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TaskPlannerView view = new TaskPlannerView();
            TaskDAO model = new TaskDAO();
            TaskController controller = new TaskController(model, view);

            NotificationsManager notificationsManager = new NotificationsManager();
            NotificationObserver observer = new NotificationObserver(view.getNotificationsArea());
            notificationsManager.addObserver(observer);


            List<Task> tasks = model.getAllTasks();
            notificationsManager.checkForNotifications(tasks);

            Timer timer = new Timer();
            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    Message message = new BasicMessage();
                    message = new BirthdayMessage(message, "18-01-2025");
                    message = new Notifications(message, notificationsManager.getNotifications());

                    view.updateMessage(message.getMessage());
                }
            }, 0, 1000);
        });
    }
}
