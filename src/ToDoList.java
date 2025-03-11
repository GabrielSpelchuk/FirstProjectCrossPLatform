import java.util.Scanner;

public class ToDoList {
    private static final Scanner scanner = new Scanner(System.in);
    private static final TaskManager taskManager = new TaskManager();

    public static void main(String[] args) {
        while(true)
        {
            System.out.println("\n=======Менеджер завдань=======");
            System.out.println("1. Переглянути всі завдання");
            System.out.println("2. Додати завдання");
            System.out.println("3. Оновити завдання");
            System.out.println("4. Видалити завдання");
            System.out.println("5. Сортувати завдання");
            System.out.println("6. Вихід");
            System.out.print("Виберіть опцію: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice)
            {
                case 1:
                    taskManager.readTasks();
                    break;
                case 2:
                    addTask();
                    break;
                case 3:
                    taskManager.updateTask();
                    break;
                case 4:
                    taskManager.deleteTask();
                    break;
                case 5:
                    sortedBy();
                    break;
                case 6:
                    System.out.println("Вихід з застосунку....");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Невірне число. Введіть ще раз.");
            }
        }
    }

    public static void addTask()
    {
        System.out.print("Введіть назву завдання: ");
        String title = scanner.nextLine();
        System.out.print("Введіть опис завдання: ");
        String description = scanner.nextLine();
        taskManager.createTask(title, description);
    }

    public static void sortedBy()
    {
        System.out.println("\nВиберіть метод сортування:");
        System.out.println("1. За заголовком");
        System.out.println("2. За довжиною опису");
        System.out.println("3. За датою створення");
        System.out.print(": ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch(choice)
        {
            case 1:
                taskManager.sortByTitle();
                break;
            case 2:
                taskManager.sortByDescription();
                break;
            case 3:
                taskManager.sortByCreatedTime();
                break;
            case 4:
                System.out.println("Число введено не вірно.");
        }
    }
}