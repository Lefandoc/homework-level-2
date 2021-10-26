package ru.gb.homework1;

import java.util.Arrays;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {

        Cat cat = new Cat("Felix", 100, 3);
        Human human = new Human("Vasya", 200, 1);
        Robot robot = new Robot("C3-PO", 300, 5);
        Participant[] participants = new Participant[3];
        participants[0] = cat;
        participants[1] = human;
        participants[2] = robot;

        Obstacle[] obstacles = {new RunningTrack(100), new Wall(2),
                new Wall(3), new RunningTrack(200)
        };

        for (Obstacle obstacle : obstacles) {
            for (Participant participant : participants) {
                participant.completeTheCourse(obstacle);
            }
        }

        Team team = new Team("Runners", participants);
        Course course = new Course(obstacles);
        course.doIt(participants);


    }
}
