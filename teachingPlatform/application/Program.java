package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import entities.Lesson;
import entities.Video;
import entities.Task;

public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Lesson> lessons = new ArrayList<>();

        System.out.print("How many lessons are in the course? ");
        int numberOfLessons = sc.nextInt();

        for (int i = 1; i <= numberOfLessons; i++) {
            System.out.println("Enter data for lesson " + i + ":");
            System.out.print("Content or task (c/t)? ");
            char type = sc.next().charAt(0);
            sc.nextLine();

            System.out.print("Title: ");
            String title = sc.nextLine();

            if (type == 'c') {
                System.out.print("Video URL: ");
                String url = sc.nextLine();
                System.out.print("Duration in seconds: ");
                int seconds = sc.nextInt();

                lessons.add(new Video(title, url, seconds));
            } else if (type == 't') {
                System.out.print("Description: ");
                String description = sc.nextLine();
                System.out.print("Number of questions: ");
                int questionCount = sc.nextInt();

                lessons.add(new Task(title, description, questionCount));
            }
        }

        int totalDuration = 0;
        for (Lesson lesson : lessons) {
            totalDuration += lesson.duration();
        }

        System.out.println();
        System.out.println("TOTAL COURSE DURATION = " + totalDuration + " seconds");

        sc.close();
    }
}

