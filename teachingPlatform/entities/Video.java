package entities;

public class Video extends Lesson {
    private final String url;
    private final int seconds;

    public Video(String title, String url, int seconds) {
        super(title);
        this.url = url;
        this.seconds = seconds;
    }

    public String getUrl() {
        return url;
    }

    public int getSeconds() {
        return seconds;
    }

    @Override
    public int duration() {
        return seconds;
    }
}

