import java.util.Comparator;

class TitleComparatorAscending implements Comparator<Task> {
    public int compare(Task t1, Task t2) {
        return t1.getTitle().compareTo(t2.getTitle());
    }
}

class TitleComparatorDescending implements Comparator<Task> {
    public int compare(Task t1, Task t2) {
        return t2.getTitle().compareTo(t1.getTitle());
    }
}

class DescriptionComparatorAscending implements Comparator<Task> {
    public int compare(Task t1, Task t2) {
        return Integer.compare(t1.getDescription().length(), t2.getDescription().length());
    }
}

class DescriptionComparatorDescending implements Comparator<Task> {
    public int compare(Task t1, Task t2) {
        return Integer.compare(t2.getDescription().length(), t1.getDescription().length());
    }
}

class CreatedAtComparatorAscending implements Comparator<Task> {
    public int compare(Task t1, Task t2) {
        return t1.getCreatedAt().compareTo(t2.getCreatedAt());
    }
}

class CreatedAtComparatorDescending implements Comparator<Task> {
    public int compare(Task t1, Task t2) {
        return t2.getCreatedAt().compareTo(t1.getCreatedAt());
    }
}