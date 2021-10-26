package ru.gb.homework2;

import java.util.Arrays;
import java.util.Random;

public class MainApp {
    public static void main(String[] args) {
        Random r = new Random();

        String[][] strings = new String[4][4];
        for (int i = 0; i < strings.length; i++) {
            for (int j = 0; j < strings[0].length; j++) {
                strings[i][j] = String.valueOf(r.nextInt(10));
            }
        }
//        strings[3][3] = "a";
        System.out.println("Исходный массив: " + Arrays.deepToString(strings));
        readStringArray(strings);
    }

    public static void readStringArray(String[][] strArr) {
        if (strArr.length != 4 || strArr[0].length != 4) {
            try {
                throw new MyArraySizeException(strArr.length, strArr[0].length);
            } catch (MyArraySizeException e) {
                e.printStackTrace();
            }
        } else {
            int sum = 0;
            for (int i = 0; i < strArr.length; i++) {
                for (int j = 0; j < strArr[0].length; j++) {
                    try {
                        sum += Integer.parseInt(strArr[i][j]);
                    } catch (NumberFormatException e) {
                        throw new MyArrayDataException(i, j);
                    }
                }
            }
            System.out.println("Сумма элементов массива: " + sum);
        }
    }
}
