package ru.gb.homework1;

public class Course {
    Obstacle[] obstacles;

    public Course(Obstacle[] obstacles) {
        this.obstacles = obstacles;
    }

    void doIt (Participant[] participants) {
        for (Obstacle obstacle : obstacles) {
            for (Participant participant : participants) {
                participant.completeTheCourse(obstacle);
            }
        }
    }
}
