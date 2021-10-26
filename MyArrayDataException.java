package ru.gb.homework2;

public class MyArrayDataException extends RuntimeException {
    private static final String ERROR_MSG = "Некорректная строка в массиве, индекс: %d, %d.";

    public MyArrayDataException(int index1, int index2) {
        super(String.format(ERROR_MSG, index1, index2));
    }
}
