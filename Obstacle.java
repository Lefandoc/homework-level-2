package ru.gb.homework1;

public abstract class Obstacle {

    abstract boolean checkResult(Cat cat);
    abstract boolean checkResult(Human human);
    abstract boolean checkResult(Robot robot);
}
