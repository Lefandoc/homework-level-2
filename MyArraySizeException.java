package ru.gb.homework2;

public class MyArraySizeException extends Exception{
    private static final String ERROR_MSG = "Неверная размерность массива: %d, %d.";

    public MyArraySizeException(int size1, int size2) {
        super(String.format(ERROR_MSG, size1, size2));
    }

}
