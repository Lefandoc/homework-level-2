package ru.gb.homework1;

public class Wall extends Obstacle {
    private int height;

    public Wall(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    boolean checkResult(Cat cat) {
        if (cat.getJumpHeight() > height) {
            System.out.println(cat.getName() + " успешно" + cat.jump(this));
            return true;
        } else {
            System.out.println(cat.getName() + " неудачно" + cat.jump(this));
            return false;
        }
    }

    @Override
    boolean checkResult(Human human) {
        if (human.getJumpHeight() > height) {
            System.out.println(human.getName() + " успешно" + human.jump(this));
            return true;
        } else {
            System.out.println(human.getName() + " неудачно" + human.jump(this));
            return false;
        }
    }

    @Override
    boolean checkResult(Robot robot) {
        if (robot.getJumpHeight() > height) {
            System.out.println(robot.getName() + " успешно" + robot.jump(this));
            return true;
        } else {
            System.out.println(robot.getName() + " неудачно" + robot.jump(this));
            return false;
        }
    }

}
