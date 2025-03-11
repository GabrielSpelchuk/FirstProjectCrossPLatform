import java.util.*;

public class TaskManager
{
    private final List<Task> tasks = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    public void createTask(String title, String description)
    {
        Task task = new Task(title, description);
        tasks.add(task);
        System.out.println("Завдання успішно додано" + task);
    }

    public void readTasks()
    {
        if(tasks.isEmpty())
            System.out.println("Список завдань пустий.");
        else
            for(Task t : tasks)
                System.out.println(t);
    }

    public void updateTask()
    {
        if (tasks.isEmpty())
        {
            System.out.println("Список завдань порожній.");
            return;
        }

        System.out.println("\n Список завдань:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }

        System.out.print("Введіть номер завдання для оновлення (0 - скасування): ");

        if(!scanner.hasNextInt())
        {
            System.out.println("Помилка: введіть число.");
            scanner.next();
            return;
        }

        int id = scanner.nextInt();
        scanner.nextLine();

        if(id == 0)
        {
            System.out.println("Оновлення скасоване.");
        }

        if(id < 1 || id > tasks.size())
        {
            System.out.println("Завдання з таким числом немає.");
            return;
        }

        System.out.print("Введіть новий заголовок: ");
        String newTitle = scanner.nextLine();
        System.out.print("Введіть новий опис: ");
        String newDescription = scanner.nextLine();

        Task task = tasks.get(id - 1);
        task.setTitle(newTitle);
        task.setDescription(newDescription);

        System.out.println("Завдання успішно оновленно.");
    }

    public void deleteTask()
    {
        if (tasks.isEmpty())
        {
            System.out.println("Список завдань порожній.");
            return;
        }

        System.out.println("\n Список завдань:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i+1) + ". " + tasks.get(i));
        }

        System.out.print("Введіть номер завдання для видалення (0 - скасування): ");

        if(!scanner.hasNextInt())
        {
            System.out.println("Помилка: введіть число.");
            scanner.next();
            return;
        }

        int id = scanner.nextInt();
        scanner.nextLine();

        if(id == 0)
        {
            System.out.println("Видалення скасоване.");
            return;
        }

        if(id < 0 || id > tasks.size())
        {
            System.out.println("Завдання з таким числом немає.");
            return;
        }

        System.out.print("Ви впевнені що хочете видалити це завдання? (так/ні): ");
        String confirmation = scanner.nextLine().trim().toLowerCase();

        if (confirmation.equals("так"))
        {
            Task taskToDelete = tasks.remove(id - 1);
            System.out.println("Завдання \"" + taskToDelete.getTitle() + "\" видалено.");
        }
        else
            System.out.println("Видалення скасоване.");
    }

    public void sortByTitle()
    {
        if(tasks.isEmpty())
        {
            System.out.println("Список завдань порожній.");
            return;
        }

        System.out.println("\nВиберіть порядок сортування:");
        System.out.println("1. За зростанням");
        System.out.println("2. За спаданням");
        System.out.print(": ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch(choice)
        {
            case 1:
                tasks.sort(new TitleComparatorAscending());
                System.out.println("Завдання успішно відсортовано:");
                break;
            case 2:
                tasks.sort(new TitleComparatorDescending());
                System.out.println("Завдання успішно відсортовано.");
                break;
            default:
                System.out.println("Число введено не вірно.");
        }
    }

    public void sortByDescription()
    {
        if(tasks.isEmpty())
        {
            System.out.println("Список завдань порожній.");
            return;
        }

        System.out.println("\nВиберіть порядок сортування:");
        System.out.println("1. За зростанням");
        System.out.println("2. За спаданням");
        System.out.print(": ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch(choice)
        {
            case 1:
                tasks.sort(new DescriptionComparatorAscending());
                System.out.println("Завдання успішно відсортовано.");
                break;
            case 2:
                tasks.sort(new DescriptionComparatorDescending());
                System.out.println("Завдання успішно відсортовано.");
                break;
            default:
                System.out.println("Число введено не вірно.");
        }
    }

    public void sortByCreatedTime()
    {
        if(tasks.isEmpty())
        {
            System.out.println("Список завдань порожній.");
            return;
        }

        System.out.println("\nВиберіть порядок сортування:");
        System.out.println("1. Від найновіших до найстарих");
        System.out.println("2. Від найстарих до найновіших");
        System.out.print(": ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch(choice)
        {
            case 1:
                tasks.sort(new CreatedAtComparatorAscending());
                System.out.println("Завдання успішно відсортовано.");
                break;
            case 2:
                tasks.sort(new CreatedAtComparatorDescending());
                System.out.println("Завдання успішно відсортовано.");
                break;
            default:
                System.out.println("Число введено не вірно.");
        }
    }
}
