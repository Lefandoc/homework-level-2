package ru.gb.homework1;

public interface Participant {

    String jump(Obstacle obstacle);

    String run(Obstacle obstacle);

    boolean completeTheCourse(Obstacle obstacle);
}
