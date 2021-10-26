package ru.gb.homework1;

public class RunningTrack extends Obstacle {
    private int length;

    public RunningTrack(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }


    @Override
    boolean checkResult(Cat cat) {
        if (cat.getRunningLength() > length) {
            System.out.println(cat.getName() + " успешно" + cat.run(this));
            return true;
        } else {
            System.out.println(cat.getName() + " неудачно" + cat.run(this));
            return false;
        }
    }

    @Override
    boolean checkResult(Human human) {
        if (human.getRunningLength() > length) {
            System.out.println(human.getName() + " успешно" + human.run(this));
            return true;
        } else {
            System.out.println(human.getName() + " неудачно" + human.run(this));
            return false;
        }
    }

    @Override
    boolean checkResult(Robot robot) {
        if (robot.getRunningLength() > length) {
            System.out.println(robot.getName() + " успешно" + robot.run(this));
            return true;
        } else {
            System.out.println(robot.getName() + " неудачно" + robot.run(this));
            return false;
        }
    }
}
