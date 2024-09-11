package entities;

public class Task extends Lesson {
    private final String description;
    private final int questionCount;

    public Task(String title, String description, int questionCount) {
        super(title);
        this.description = description;
        this.questionCount = questionCount;
    }

    public String getDescription() {
        return description;
    }

    public int getQuestionCount() {
        return questionCount;
    }

    @Override
    public int duration() {
        return questionCount * 300; //conversion in minutes 5 min->300 sec
    }
}

