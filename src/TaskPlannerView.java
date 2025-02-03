import javax.swing.*;
import java.awt.*;

public class TaskPlannerView {
    private JFrame frame;
    private JLabel birthdayMessageLabel;
    private JTextArea notificationsArea;
    private DefaultListModel<String> taskListModel;
    private JList<String> taskList;
    private JButton addTaskButton;
    private JButton deleteTaskButton;
    private JButton editTaskButton;

    public TaskPlannerView() {
        frame = new JFrame("Task Planner");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new GridLayout(3, 1));
        birthdayMessageLabel = new JLabel("Birthday Celebration Message: ");
        topPanel.add(birthdayMessageLabel);
        JPanel centerPanel = new JPanel(new GridLayout(1, 2));
        JPanel notificationsPanel = new JPanel(new BorderLayout());
        notificationsPanel.setBorder(BorderFactory.createTitledBorder("Notifications"));
        notificationsArea = new JTextArea();
        notificationsArea.setEditable(false);
        notificationsPanel.add(new JScrollPane(notificationsArea), BorderLayout.CENTER);

        JPanel taskListPanel = new JPanel(new BorderLayout());
        taskListPanel.setBorder(BorderFactory.createTitledBorder("Task List"));
        taskListModel = new DefaultListModel<>();
        taskList = new JList<>(taskListModel);
        taskListPanel.add(new JScrollPane(taskList), BorderLayout.CENTER);

        JPanel taskButtonsPanel = new JPanel(new GridLayout(1, 3));

        ImageIcon addIcon = new ImageIcon(new ImageIcon("src/images/add.png")
                .getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
        addTaskButton = new JButton(addIcon);

        ImageIcon deleteIcon = new ImageIcon(new ImageIcon("src/images/trash.png")
                .getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
        deleteTaskButton = new JButton(deleteIcon);

        ImageIcon editIcon = new ImageIcon(new ImageIcon("src/images/edit.png")
                .getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
        editTaskButton = new JButton(editIcon);


        JButton[] buttons = {deleteTaskButton, addTaskButton, editTaskButton};
        for (JButton button : buttons) {
            button.setText(null);
            button.setBorderPainted(false);
            button.setContentAreaFilled(false);
            button.setFocusPainted(false);
        }
        taskButtonsPanel.add(addTaskButton);
        taskButtonsPanel.add(deleteTaskButton);
        taskButtonsPanel.add(editTaskButton);
        taskListPanel.add(taskButtonsPanel, BorderLayout.SOUTH);

        centerPanel.add(notificationsPanel);
        centerPanel.add(taskListPanel);

        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(centerPanel, BorderLayout.CENTER);
        frame.setVisible(true);

    }

    public JButton getAddTaskButton() { return addTaskButton; }
    public JButton getDeleteTaskButton() { return deleteTaskButton; }
    public JButton getEditTaskButton() { return editTaskButton; }
    public DefaultListModel<String> getTaskListModel() { return taskListModel; }
    public JList<String> getTaskList() { return taskList; }
    public JTextArea getNotificationsArea() {
        return notificationsArea;
    }
    public void updateMessage(String message) {
        birthdayMessageLabel.setText(message);
    }


}
