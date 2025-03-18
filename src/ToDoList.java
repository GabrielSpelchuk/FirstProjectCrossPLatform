import java.util.Scanner;

public class ToDoList {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final TaskManager taskManager = new TaskManager();
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

            int id;
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice)
            {
                case 1:
                    taskManager.readTasks();
                    break;

                case 2:
                    System.out.print("Введіть назву завдання: ");
                    String title = scanner.nextLine();
                    System.out.print("Введіть опис завдання: ");
                    String description = scanner.nextLine();
                    taskManager.createTask(title, description);
                    break;

                case 3:
                    if (taskManager.tasks.isEmpty())
                    {
                        System.out.println("Список завдань порожній.");
                        return;
                    }

                    System.out.println("\n Список завдань:");
                    for (int i = 0; i < taskManager.tasks.size(); i++)
                        System.out.println((i + 1) + ". " + taskManager.tasks.get(i));

                    System.out.print("Введіть номер завдання для оновлення (0 - скасування): ");

                    if(!scanner.hasNextInt())
                    {
                        System.out.println("Помилка: введіть число.");
                        scanner.next();
                        return;
                    }

                    id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Введіть новий заголовок: ");
                    String newTitle = scanner.nextLine();
                    System.out.print("Введіть новий опис: ");
                    String newDescription = scanner.nextLine();

                    taskManager.updateTask(id, newTitle, newDescription);
                    break;

                case 4:
                    if (taskManager.tasks.isEmpty())
                    {
                        System.out.println("Список завдань порожній.");
                        return;
                    }

                    System.out.println("\n Список завдань:");
                    for (int i = 0; i < taskManager.tasks.size(); i++)
                        System.out.println((i+1) + ". " + taskManager.tasks.get(i));

                    System.out.print("Введіть номер завдання для видалення (0 - скасування): ");

                    if(!scanner.hasNextInt())
                    {
                        System.out.println("Помилка: введіть число.");
                        scanner.next();
                        return;
                    }

                    id = scanner.nextInt();
                    scanner.nextLine();

                    taskManager.deleteTask(id);
                    break;

                case 5:
                    System.out.println("\nВиберіть метод сортування:");
                    System.out.println("1. За заголовком");
                    System.out.println("2. За довжиною опису");
                    System.out.println("3. За датою створення");
                    System.out.print(": ");

                    choice = scanner.nextInt();
                    scanner.nextLine();

                    switch(choice)
                    {
                        case 1:
                            if(taskManager.tasks.isEmpty())
                            {
                                System.out.println("Список завдань порожній.");
                                return;
                            }

                            System.out.println("\nВиберіть порядок сортування:");
                            System.out.println("1. За зростанням");
                            System.out.println("2. За спаданням");
                            System.out.print(": ");

                            choice = scanner.nextInt();
                            scanner.nextLine();

                            taskManager.sortByTitle(choice);
                            break;

                        case 2:
                            if(taskManager.tasks.isEmpty())
                            {
                                System.out.println("Список завдань порожній.");
                                return;
                            }

                            System.out.println("\nВиберіть порядок сортування:");
                            System.out.println("1. За зростанням");
                            System.out.println("2. За спаданням");
                            System.out.print(": ");

                            choice = scanner.nextInt();
                            scanner.nextLine();

                            taskManager.sortByDescription(choice);
                            break;

                        case 3:
                            if(taskManager.tasks.isEmpty())
                            {
                                System.out.println("Список завдань порожній.");
                                return;
                            }

                            System.out.println("\nВиберіть порядок сортування:");
                            System.out.println("1. За зростанням");
                            System.out.println("2. За спаданням");
                            System.out.print(": ");

                            choice = scanner.nextInt();
                            scanner.nextLine();

                            taskManager.sortByCreatedTime(choice);
                            break;

                        default:
                            System.out.println("Число введено не вірно.");
                            break;
                    }
                    break;

                case 6:
                    System.out.println("Вихід з застосунку....");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Невірне число. Введіть ще раз.");
                    break;
            }
        }
    }
}