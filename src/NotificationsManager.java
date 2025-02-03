import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class NotificationsManager implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private List<String> notifications = new ArrayList<>();

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {

        for (Observer observer : observers) {
            observer.update(notifications);
        }
    }

    public void checkForNotifications(List<Task> tasks) {
        notifications.clear();
        LocalDate today = LocalDate.now();

        for (Task task : tasks) {
            LocalDate deadline = LocalDate.parse(task.getDeadline(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));

            if (deadline.equals(today.plusDays(1))) {
                notifications.add("Task '" + task.getName() + "' is due tomorrow!");
            } else if (deadline.isBefore(today)) {
                notifications.add("Task '" + task.getName() + "' is overdue!");
            }
        }

        notifyObservers();
    }
    public List<String> getNotifications() {
        return notifications;
    }
}

