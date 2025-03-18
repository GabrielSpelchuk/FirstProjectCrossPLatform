import java.util.*;

public class TaskManager
{
    public List<Task> tasks = new ArrayList<>();

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

    public void updateTask(int id, String newTitle, String newDescription)
    {
        if(id == 0)
        {
            System.out.println("Оновлення скасоване.");
        }

        if(id < 1 || id > tasks.size())
        {
            System.out.println("Завдання з таким числом немає.");
            return;
        }

        Task task = tasks.get(id - 1);
        task.setTitle(newTitle);
        task.setDescription(newDescription);

        System.out.println("Завдання успішно оновленно.");
    }

    public void deleteTask(int id)
    {
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

        Task taskToDelete = tasks.remove(id - 1);
        System.out.println("Завдання \"" + taskToDelete.getTitle() + "\" видалено.");
    }

    public void sortByTitle(int choice)
    {
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

    public void sortByDescription(int choice)
    {
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

    public void sortByCreatedTime(int choice)
    {
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
