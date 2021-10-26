package ru.gb.homework1;

public class Robot implements Participant {
    private String name;
    private int runningLength;
    private int jumpHeight;

    public Robot(String name, int runningLength, int jumpHeight) {
        this.name = name;
        this.runningLength = runningLength;
        this.jumpHeight = jumpHeight;
    }

    public int getRunningLength() {
        return runningLength;
    }

    public int getJumpHeight() {
        return jumpHeight;
    }

    public String getName() {
        return name;
    }

    @Override
    public String jump(Obstacle obstacle) {
        return " прыгает через стену ";
    }

    @Override
    public String run(Obstacle obstacle) {
        return  " пробегает беговую дорожку";
    }

    @Override
    public boolean completeTheCourse(Obstacle obstacle) {
        return obstacle.checkResult(this);
    }
}