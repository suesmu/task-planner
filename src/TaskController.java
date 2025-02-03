import javax.swing.*;
import java.util.List;

public class TaskController {
    private TaskDAO taskDAO;
    private TaskPlannerView view;
   private SortByDate sortByDate;

    public TaskController(TaskDAO taskDAO, TaskPlannerView view) {
        this.taskDAO = taskDAO;
        this.view = view;
        this.sortByDate=new SortByDate();

        view.getAddTaskButton().addActionListener(e -> addTask());
        view.getDeleteTaskButton().addActionListener(e -> deleteTask());
        view.getEditTaskButton().addActionListener(e -> editTask());

        loadTasks();
    }


    public void loadTasks() {

        List<Task> tasks = taskDAO.getAllTasks();
        sortByDate.sort(tasks);

        view.getTaskListModel().clear();
        for (Task task : tasks) {
            view.getTaskListModel().addElement(task.getId() + ": " + task.getName() + " - " + task.getCategory());
        }
    }

    private void addTask() {

        String name = JOptionPane.showInputDialog("Task Name:");
        String description = JOptionPane.showInputDialog("Description:");
        String category = JOptionPane.showInputDialog("Category:");
        String deadline = JOptionPane.showInputDialog("Deadline (YYYY-MM-DD):");

        if (name != null && description != null && category != null && deadline != null) {
            Task newTask = new Task(0, name, description, category, deadline);
            taskDAO.addTask(newTask);



            
            List<Task> tasks = taskDAO.getAllTasks();
            NotificationsManager notificationsManager = new NotificationsManager();
            notificationsManager.addObserver(new NotificationObserver(view.getNotificationsArea()));
            notificationsManager.checkForNotifications(tasks);



            loadTasks();
            JOptionPane.showMessageDialog(null, "Task added successfully!");
        }
    }

    private void deleteTask() {
        int selectedIndex = view.getTaskList().getSelectedIndex();
        if (selectedIndex != -1) {
            String selectedTask = view.getTaskListModel().get(selectedIndex);
            int taskId = Integer.parseInt(selectedTask.split(":")[0]);

            taskDAO.deleteTask(taskId);



            List<Task> tasks = taskDAO.getAllTasks();
            NotificationsManager notificationsManager = new NotificationsManager();
            notificationsManager.addObserver(new NotificationObserver(view.getNotificationsArea()));
            notificationsManager.checkForNotifications(tasks);


            loadTasks();
            JOptionPane.showMessageDialog(null, "Task deleted successfully!");
        } else {
            JOptionPane.showMessageDialog(null, "Please select a task to delete!");
        }
    }

    private void editTask() {
        int selectedIndex = view.getTaskList().getSelectedIndex();
        if (selectedIndex != -1) {
            String selectedTask = view.getTaskListModel().get(selectedIndex);
            int taskId = Integer.parseInt(selectedTask.split(":")[0]);

            String name = JOptionPane.showInputDialog("New Task Name:");
            String description = JOptionPane.showInputDialog("New Description:");
            String category = JOptionPane.showInputDialog("New Category:");
            String deadline = JOptionPane.showInputDialog("New Deadline (YYYY-MM-DD):");

            if (name != null && description != null && category != null && deadline != null) {
                Task updatedTask = new Task(taskId, name, description, category, deadline);
                taskDAO.updateTask(updatedTask);

                List<Task> tasks = taskDAO.getAllTasks();
                NotificationsManager notificationsManager = new NotificationsManager();
                notificationsManager.addObserver(new NotificationObserver(view.getNotificationsArea()));
                notificationsManager.checkForNotifications(tasks);
                loadTasks();
                JOptionPane.showMessageDialog(null, "Task updated successfully!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select a task to edit!");
        }
    }
}
